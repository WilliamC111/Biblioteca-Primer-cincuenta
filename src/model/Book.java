package model;

import java.util.ArrayList;

public class Book implements Comparable<Book> {
    private String title;
    private String isbn;
    private String volume;
    private String editorial;
    private Headquarters headquarters;
    private Author author;

    public Book(String title, int i, String isbn, String volume, String editorial, Headquarters headquarters, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.volume = volume;
        this.editorial = editorial;
        this.headquarters = headquarters;
        this.author = author;
    }

    

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getVolume() {
        return volume;
    }

    public String getEditorial() {
        return editorial;
    }

    public Headquarters getHeadquarters() {
        return headquarters;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public int compareTo(Book otherBook) {
        return this.title.compareTo(otherBook.title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", volume='" + volume + '\'' +
                ", editorial='" + editorial + '\'' +
                ", headquarters=" + headquarters +
                ", author=" + author +
                '}';
    }
}
