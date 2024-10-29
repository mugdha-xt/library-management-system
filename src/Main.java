import Book.Book;
import Book.Inventory;
import Library.CheckoutCounter;
import Library.Library;
import Member.Member;
import Member.MemberPanel;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Book art_book = new Book("Art", "art_author", 110);
        Book art_book2 = new Book("Art 2", "art_author2", 120);
        Book science_book = new Book("Science", "science_author", 240);
        Book science_book2 = new Book("Science", "science_author", 340);
        Book tech_book = new Book("Tech", "tech_author", 330);

        Inventory inventory = new Inventory();

        MemberPanel memberPanel = new MemberPanel();

        CheckoutCounter checkoutCounter = new CheckoutCounter();

        Library library = new Library(memberPanel, inventory, checkoutCounter);

        library.addBookList(List.of(art_book2, art_book, science_book, science_book2));
        library.addBook(tech_book);

        Member m1 = library.addAsMember("m1", "1234", "a1");
        Member m2 = library.addAsMember("m2", "1256", "a2");
        Member m3 = library.addAsMember("m3", "4566", "a2");

        List<Book> booksbyauthor = library.searchBookByAuthor("science_author");
        for (Book book : booksbyauthor) {
            book.displayInfo();
        }
        library.checkoutBook(art_book, m1);
        library.checkoutBook(science_book, m2);
        library.checkoutBook(science_book2, m2);
        library.checkoutBook(tech_book, m3);
        library.returnBook(tech_book, m3);
        library.checkoutBook(art_book2, m3);

        // Failure Sccenarios
        library.checkoutBook(art_book2, m1);
        library.returnBook(tech_book, m1);
    }
}