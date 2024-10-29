package Card;

import Book.Book;

import java.time.LocalDate;

public class Entry {

    private LocalDate checkoutDate;

    private LocalDate returnDate;

    private Book book;

    public Entry(Book book) {
        this(book, LocalDate.now());
    }
    public Entry(Book book, LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
        this.book = book;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void markAsReturned() {
        this.setReturnDate(LocalDate.now());
    }
}
