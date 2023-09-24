package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.AVLTree;
import model.Author;
import model.Book;
import model.Headquarters;
import view.BookListWindow;
import view.PrincipalWindow;
import view.SearchResultWindow;

public class Manager implements ActionListener {
    private AVLTree<Book> bookTree;
    private PrincipalWindow principal;

    private static final String BOOKS_FILE_PATH = "Books.txt";

    public Manager() {
        createTree();
        loadBooksFromFile(); 
        principal = new PrincipalWindow(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.getBtnBuscar()) {
            searchBook();
        } else  if (e.getSource() == principal.getBtnAgregar()) {
            addBookFromUserInput();
        } else if (e.getSource() == principal.getBtnEliminar()) {
            String isbnStr = JOptionPane.showInputDialog(principal, "Ingrese el ISBN del libro a eliminar:");
            if (isbnStr != null && !isbnStr.isEmpty()) {
                try {
                    int isbn = Integer.parseInt(isbnStr);
                    deleteBook(isbn);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(principal, "ISBN no válido. Debe ser un número entero.");
                }
            } else {
                JOptionPane.showMessageDialog(principal, "ISBN no válido.");
            }
        }
        if (e.getSource() == principal.getBtnListar()) {
            String sede = (String) principal.getComboBox().getSelectedItem();
            List<Book> booksInSede = listBooksByHeadquarters(sede);
            new BookListWindow(booksInSede);
        }
    }
    
    private void addBookFromUserInput() {
        String title = JOptionPane.showInputDialog(principal, "Ingrese el título del libro:");
        if (title == null || title.isEmpty()) {
            JOptionPane.showMessageDialog(principal, "El título del libro es obligatorio.");
            return;
        }

        int isbn;
        try {
            String isbnStr = JOptionPane.showInputDialog(principal, "Ingrese el ISBN del libro:");
            if (isbnStr == null || isbnStr.isEmpty()) {
                JOptionPane.showMessageDialog(principal, "El ISBN del libro es obligatorio.");
                return;
            }
            isbn = Integer.parseInt(isbnStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(principal, "ISBN no válido. Debe ser un número entero.");
            return;
        }
   
        String volume = JOptionPane.showInputDialog(principal, "Ingrese el volumen del libro:");
        String editorial = JOptionPane.showInputDialog(principal, "Ingrese la editorial del libro:");

        String sede = (String) principal.getComboBox().getSelectedItem();
        Headquarters headquarters = new Headquarters(sede);

        String authorFirstName = JOptionPane.showInputDialog(principal, "Ingrese el nombre del autor:");
        String authorLastName = JOptionPane.showInputDialog(principal, "Ingrese el apellido del autor:");
        Author author = new Author(authorFirstName, authorLastName, "");

        int copiesAvailable;
        try {
            String copiesAvailableStr = JOptionPane.showInputDialog(principal, "Ingrese la cantidad de copias disponibles:");
            if (copiesAvailableStr == null || copiesAvailableStr.isEmpty()) {
                JOptionPane.showMessageDialog(principal, "La cantidad de copias disponibles es obligatoria.");
                return;
            }
            copiesAvailable = Integer.parseInt(copiesAvailableStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(principal, "Cantidad de copias no válida. Debe ser un número entero.");
            return;
        }

        Book book = new Book(title, isbn, volume, editorial, headquarters, author, copiesAvailable);
        addBook(book);
        saveBookToFile(book);
        JOptionPane.showMessageDialog(principal, "Libro agregado exitosamente.");
    }
    private void saveBookToFile(Book book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE_PATH, true))) {
            writer.write(book.toFileString());
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(principal, "Error al guardar el libro en el archivo: " + e.getMessage());
        }
    }
    private void searchBook() {
        String query = JOptionPane.showInputDialog(principal,
                "Ingrese el título, ISBN o deje en blanco para buscar todos los libros:");

        if (query == null) {
            return; // User clicked cancel
        }

        SearchResultWindow resultWindow = new SearchResultWindow("Resultado de la búsqueda");
        resultWindow.displayResults(searchBooks(query));
    }

    

    private void deleteBook(int isbn) {
        Book bookToDelete = bookTree.searchByISBN(isbn);
        if (bookToDelete != null) {
            bookTree.delete(bookToDelete);
        } else {
            JOptionPane.showMessageDialog(principal, "No se encontró el libro a eliminar.");
        }
    }

    private List<Book> listBooksByHeadquarters(String sede) {
        List<Book> booksInHeadquarters = new ArrayList<>();
        bookTree.inOrderTraversal(book -> {
            if (book.getHeadquarters().getHeadquartersName().equals(sede)) {
                booksInHeadquarters.add(book);
            }
        });
        return booksInHeadquarters;
    }
    
    private String searchBooks(String query) {
        StringBuilder result = new StringBuilder();
    
        bookTree.inOrderTraversal(book -> {
            String title = book.getTitle().toLowerCase();
            String isbn = String.valueOf(book.getIsbn());
    
            if (title.contains(query.toLowerCase()) || isbn.equals(query)) {
                result.append("Libro: ").append(book.getTitle()).append("\n");
                result.append("ISBN: ").append(book.getIsbn()).append("\n");
                result.append("Copias disponibles en cada sede:\n");
    
                Headquarters headquarters = book.getHeadquarters();
    
                // Check if the book is in the current headquarters using the AVL tree
                Book searchResult = bookTree.search(book);
                if (searchResult != null && searchResult.getHeadquarters().equals(headquarters)) {
                    result.append("- ").append(headquarters.getHeadquartersName()).append(": ")
                            .append(searchResult.getCopiesAvailable()).append(" copias\n");
                }
    
                result.append("\n");
            }
        });
    
        return result.toString();
    }
    private void displayBooks(List<Book> books) {
        StringBuilder displayText = new StringBuilder();
        for (Book book : books) {
            displayText.append(book.toString()).append(", Copies Available: ").append(book.getCopiesAvailable()).append("\n");
        }
        principal.updateLabelText(displayText.toString());
    }

    private void createTree() {
        bookTree = new AVLTree<>();
    }

  

    private void loadBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookData = line.split(";");
                if (bookData.length == 7) {
                  
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al cargar libros desde el archivo: " + e.getMessage());
        }
    }

    private void addBook(Book book) {
        bookTree.insert(book);
    }

    public static void main(String[] args) {
        Manager manager = new Manager();

    }
}
