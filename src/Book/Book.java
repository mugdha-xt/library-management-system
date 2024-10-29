package Book;

public class Book {

    private String title;

    private String author;

    private Integer isbn;

    private Integer publicationYear;

    private Boolean isAvailable;

    public Book(String title, String author, Integer isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public Book(String title, String author, Integer isbn, Integer publicationYear) {
        this(title, author, isbn);
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Boolean isAvailable() {
        return this.isAvailable;
    }

    public void setCheckedOut() {
        this.isAvailable = false;
    }

    public void setReturned() {
        this.isAvailable = true;
    }

    public void displayInfo() {
        System.out.println("Book Information:");
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Publication Year: " + this.publicationYear);
        System.out.println("Is Available to Checkout: " + (this.isAvailable ? "Yes" : "No"));
    }
}
