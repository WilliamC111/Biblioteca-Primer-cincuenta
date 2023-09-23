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
    public void delete(T data) {
        root = delete(root, data);
    }
    private AVLNode<T> delete(AVLNode<T> root, T data) {
        if (root == null)
            return root;

        if (data.compareTo(root.data) < 0)
            root.left = delete(root.left, data);
        else if (data.compareTo(root.data) > 0)
            root.right = delete(root.right, data);
        else {
            if (root.left == null || root.right == null) {
                AVLNode<T> temp = (root.left != null) ? root.left : root.right;
                if (temp == null)
                    temp = root;

                root = temp;
            } else {
                AVLNode<T> successor = findMin(root.right);
                root.data = successor.data;
                root.right = delete(root.right, successor.data);
            }
        }
        if (root == null)
            return root;
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        if (balance > 1) {
            if (getBalance(root.left) >= 0)
                return rightRotate(root);
            else {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }

        if (balance < -1) {
            if (getBalance(root.right) <= 0)
                return leftRotate(root);
            else {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }

        return root;
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

}
