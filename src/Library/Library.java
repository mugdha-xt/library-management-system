package Library;

import Book.Book;
import Book.Inventory;
import Member.Member;
import Member.MemberPanel;

import java.util.List;

public class Library {

    private MemberPanel memberPanel;

    private Inventory inventory;

    private CheckoutCounter checkoutCounter;

    public Library(MemberPanel memberPanel, Inventory inventory, CheckoutCounter checkoutCounter) {
        this.memberPanel = memberPanel;
        this.inventory = inventory;
        this.checkoutCounter = checkoutCounter;
    }

    public void checkoutBook(Book book, Member member) {
        if (checkoutCounter.checkoutBook(book, member)) {
            System.out.println("Checkout successfully");
        } else {
            System.out.println("Failed to checkout book");
        }

    }

    public void returnBook(Book book, Member member) {
        if (checkoutCounter.returnBook(book, member)) {
            System.out.println("Returned book successfully");
        } else {
            System.out.println("Failed to return book");
        }
    }

    public Member addAsMember(String name, String number, String address) {
        return memberPanel.addAsMember(name, number, address);
    }

    public void removeMember(Member member) {
        if (memberPanel.removeMember(member)) {
            System.out.println("Removed member successfully");
        } else {
            System.out.println("Failed to remove member");
        }
    }

    public void updateMember(Member member) {
        if (memberPanel.updateMember(member)) {
            System.out.println("Updated member successfully");
        } else {
            System.out.println("Failed to update member");
        }
    }

    public void addBookList(List<Book> bookList) {
        if (inventory.addBookList(bookList)) {
            System.out.println("Successfully added books");
        } else {
            System.out.println("Failed to add book");
        }
    }

    public void addBook(Book book) {
        if (inventory.addBook(book)) {
            System.out.println("Successfully added book");
        } else {
            System.out.println("Failed to add book");
        }
    }

    public void removeBook(Book book) {
        if (inventory.removeBook(book)) {
            System.out.println("Successfully removed book");
        } else {
            System.out.println("Failed to remove book");
        }
    }

    public List<Book> searchBook() {
        return inventory.getAllBooks();
    }

    public List<Book> searchBookByAuthor(String author) {
        return inventory.searchBookByAuthor(author);
    }

    public List<Book> searchBookByTitle(String title) {
        return inventory.searchBookByTitle(title);
    }

    public Book searchBookById(Integer id) {
        return inventory.searchBookByIsbn(id);
    }

    public List<Book> getAvailableBooks() {
        return inventory.getAvailableBooks();
    }

    public List<Book> getBorrowedBooks() {
        return inventory.getBorrowedBooks();
    }

}
