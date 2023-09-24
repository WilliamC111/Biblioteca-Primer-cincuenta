package model;

public class Book implements Comparable<Book> {
    private String title;
    private int isbn;
    private String volume;
    private String editorial;
    private Headquarters headquarters;
    private Author author;
    private int copiesAvailable;

    public Book(String title, int isbn, String volume, String editorial, Headquarters headquarters, Author author, int copiesAvailable) {
        this.title = title;
        this.isbn = isbn;
        this.volume = volume;
        this.editorial = editorial;
        this.headquarters = headquarters;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public String getTitle() {
        return title;
    }

    public int getIsbn() {
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

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    @Override
public int compareTo(Book otherBook) {
    return this.isbn - otherBook.isbn;
    }

    public String toFileString() {
        return String.format("%s;%d;%s;%s;%s;%s %s;%d",
                title, isbn, volume, editorial, headquarters.getHeadquartersName(),
                author.getFirstName(), author.getLastName(), copiesAvailable);
    }
}
