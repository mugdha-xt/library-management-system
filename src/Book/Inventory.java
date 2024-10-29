package Book;

import java.util.*;

public class Inventory {

    private Map<Integer, Book> booksMap;

    private Map<String, List<Book>> booksByAuthor;

    private Map<String, List<Book>> booksByTitle;

    public Inventory() {
        booksMap = new HashMap<Integer, Book>();
        booksByAuthor = new HashMap<>();
        booksByTitle = new HashMap<>();
    }

    public Boolean addBookList(List<Book> bookList) {
        for (Book book : bookList) {
            if(!addBook(book)) {
                return false;
            }
        }
        return true;
    }

    public Boolean addBook(Book book) {
        if (booksMap.containsKey(book.getIsbn())) {
            System.out.printf("Book with ISBN %d already exists%n", book.getIsbn());
            return false;
        }
        this.booksMap.put(book.getIsbn(), book);
        this.addBookToAuthorMap(book);
        this.addBookToTitleMap(book);
        return true;
    }

    private void addBookToAuthorMap(Book book) {
        List<Book> bookList = this.booksByAuthor.getOrDefault(book.getAuthor(), new ArrayList<>());
        bookList.add(book);
        this.booksByAuthor.put(book.getAuthor(), bookList);
    }

    private void addBookToTitleMap(Book book) {
        List<Book> bookList = this.booksByTitle.getOrDefault(book.getTitle(), new ArrayList<>());
        bookList.add(book);
        this.booksByTitle.put(book.getTitle(), bookList);
    }

    public Boolean removeBook(Book book) {
        return removeBookById(book.getIsbn());
    }

    private Boolean removeBookById(Integer isbn) {
        if (!booksMap.containsKey(isbn)) {
            System.out.printf("Book with ISBN %d doesn't exists%n", isbn);
            return false;
        }
        Book book = booksMap.get(isbn);
        this.removeBookFromAuthorMap(book);
        this.removeBookFromTitleMap(book);
        this.booksMap.remove(isbn);
        return true;
    }

    private void removeBookFromAuthorMap(Book book) {
        List<Book> bookList = this.booksByAuthor.get(book.getAuthor());
        Book bookToRemove = bookList.stream().filter(b -> Objects.equals(b.getIsbn(), book.getIsbn())).findFirst().get();
        bookList.remove((bookToRemove));
    }

    private void removeBookFromTitleMap(Book book) {
        List<Book> bookList = this.booksByTitle.get(book.getTitle());
        Book bookToRemove = bookList.stream().filter(b -> Objects.equals(b.getIsbn(), book.getIsbn())).findFirst().get();
        bookList.remove((bookToRemove));
    }

    public List<Book> searchBookByAuthor(String author) {
        return this.booksByAuthor.getOrDefault(author, Collections.emptyList());
    }

    public List<Book> searchBookByTitle(String title) {
        return this.booksByTitle.getOrDefault(title, Collections.emptyList());
    }

    public Book searchBookByIsbn(Integer isbn) {
        return this.booksMap.get(isbn);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<Book>(this.booksMap.values());
    }

    public List<Book> getAvailableBooks() {
        return booksMap.values().stream().filter(book -> book.isAvailable()).toList();
    }

    public List<Book> getBorrowedBooks() {
        return booksMap.values().stream().filter(book -> !book.isAvailable()).toList();
    }
}
