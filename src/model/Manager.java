package model;

import java.util.List;

public class Manager {
    AVLTree avlTree;

    public Manager(){
        avlTree = new AVLTree<>();
    }
    public void  addBook(Book book){
        avlTree.insert(book);
    }

    public Book search(String isbn){
        return avlTree.searchByISBN(isbn);
    }

    public void Delete(String isbn, String Headquarters){
        avlTree.deleteByISBNAndHeadquarters(isbn,Headquarters);
    }

    public AVLTree getAvlTree(){
        return avlTree;
    }
    
    public List<Book> listbooks(){
        return avlTree.listbooks();
    }

    public void recorrer (List<Book>list){
        for (Book book : list) {
            System.out.println(book.toString());
        }
    }



    public static void main(String[] args) {
        Manager manager = new Manager();

        manager.addBook(new Book("Mi Libro", "ISBN12345", "Volumen 1", "Editorial XYZ",
        new Headquarters("Tunja")));
        manager.addBook(new Book("Libro 2", "ISBN22222", "Volumen 2", "Editorial XYZ", new Headquarters("Bogotá")));
        
        manager.recorrer(manager.listbooks());
        
        
        /* manager.Delete("ISBN22222", "Bogotá");
    
        // Intenta buscar el libro después de eliminarlo para verificar si se ha eliminado correctamente.
        Book deletedBook = manager.search("ISBN22222");
        if (deletedBook == null) {
            System.out.println("El libro ha sido eliminado correctamente.");
        } else {
            System.out.println("El libro no se ha eliminado correctamente.");
        }*/ 

    }
}
