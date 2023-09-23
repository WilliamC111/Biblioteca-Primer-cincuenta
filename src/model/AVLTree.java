package model;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<T extends Comparable<T>> {
    private AVLNode<T> root;

    public void insert(T data) {
        root = insert(root, data);
    }

    private int height(AVLNode<T> node) {
        if (node == null)
            return 0;
        return node.height;
    }

    private int getBalance(AVLNode<T> node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    private AVLNode<T> rightRotate(AVLNode<T> y) {
        AVLNode<T> x = y.left;
        AVLNode<T> T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private AVLNode<T> leftRotate(AVLNode<T> x) {
        AVLNode<T> y = x.right;
        AVLNode<T> T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        searchByTitle(root, title, result);
        return result;
    }

    private void searchByTitle(AVLNode<T> node, String title, List<Book> result) {
        if (node == null)
            return;

        int cmp = title.compareTo(((Book) node.data).getTitle());
        if (cmp < 0)
            searchByTitle(node.left, title, result);
        else if (cmp > 0)
            searchByTitle(node.right, title, result);
        else {
            result.add((Book) node.data);
            searchByTitle(node.left, title, result);
            searchByTitle(node.right, title, result);
        }
    }


    public Book searchByISBN(String isbn) {
        return searchByISBN(root, isbn);
    }

    private Book searchByISBN(AVLNode<T> node, String isbn) {
        if (node == null)
            return null;

        int cmp = isbn.compareTo(((Book) node.data).getIsbn());
        if (cmp < 0)
            return searchByISBN(node.left, isbn);
        else if (cmp > 0)
            return searchByISBN(node.right, isbn);
        else
            return (Book) node.data;
    }

    private AVLNode<T> insert(AVLNode<T> node, T data) {
        if (node == null)
            return new AVLNode<>(data);

        if (data.compareTo(node.data) < 0)
            node.left = insert(node.left, data);
        else if (data.compareTo(node.data) > 0)
            node.right = insert(node.right, data);
        else
            return node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        if (balance > 1) {
            if (data.compareTo(node.left.data) < 0)
                return rightRotate(node);
            else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (balance < -1) {
            if (data.compareTo(node.right.data) > 0)
                return leftRotate(node);
            else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }
   
    public void deleteByISBNAndHeadquarters(String isbn, String headquarters) {
        root = deleteByISBNAndHeadquarters(root, isbn, headquarters);
    }
    
    private AVLNode<T> deleteByISBNAndHeadquarters(AVLNode<T> node, String isbn, String headquarters) {
        if (node == null)
            return node;
    
        // Realizar comparaciones para determinar si el libro debe eliminarse
        Book book = (Book) node.data; // Accede al libro almacenado en el nodo
        int cmpIsbn = isbn.compareTo(book.getIsbn());
        int cmpHeadquarters = headquarters.compareTo(book.getHeadquarters().getHeadquartersName());
    
        if (cmpIsbn < 0) {
            node.left = deleteByISBNAndHeadquarters(node.left, isbn, headquarters);
        } else if (cmpIsbn > 0) {
            node.right = deleteByISBNAndHeadquarters(node.right, isbn, headquarters);
        } else {
            // El ISBN coincide, ahora verifica la sede
            if (cmpHeadquarters < 0) {
                node.left = deleteByISBNAndHeadquarters(node.left, isbn, headquarters);
            } else if (cmpHeadquarters > 0) {
                node.right = deleteByISBNAndHeadquarters(node.right, isbn, headquarters);
            } else {
                // Encontrado el libro con el ISBN y la sede correctos, procede a eliminarlo
                if (node.left == null || node.right == null) {
                    AVLNode<T> temp = (node.left != null) ? node.left : node.right;
                    if (temp == null)
                        temp = node;
                    return temp;
                } else {
                    AVLNode<T> successor = findMin(node.right);
                    book = (Book) successor.data; // Accede al libro sucesor
                    node.data = successor.data;
                    node.right = deleteByISBNAndHeadquarters(node.right, book.getIsbn(), headquarters);
                }
            }
        }
    
        // Actualizar la altura y equilibrar el árbol como en otros métodos de eliminación
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);
        if (balance > 1) {
            if (getBalance(node.left) >= 0)
                return rightRotate(node);
            else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (balance < -1) {
            if (getBalance(node.right) <= 0)
                return leftRotate(node);
            else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
    
        return node;
    }
    

    private AVLNode<T> findMin(AVLNode<T> node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    public T search(T data) {
        return search(root, data);
    }

    private T search(AVLNode<T> node, T data) {
        if (node == null)
            return null;

        if (data.compareTo(node.data) < 0)
            return search(node.left, data);
        else if (data.compareTo(node.data) > 0)
            return search(node.right, data);
        else
            return node.data;
    }
    public List<Book> listbooks() {
        List<Book> books = new ArrayList<>();
        inOrderTraversal(root,books);
        return books;
    }

  

    private void inOrderTraversal(AVLNode<T> node,List<Book> books ) {
        if (node != null) {
            inOrderTraversal(node.left,books); // Visitar el subárbol izquierdo
            books.add((Book)node.data);
             // Imprimir el libro
            inOrderTraversal(node.right,books); // Visitar el subárbol derecho
        }
    }
}
