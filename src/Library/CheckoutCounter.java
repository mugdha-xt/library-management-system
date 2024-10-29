package Library;

import Book.Book;
import Card.LibraryCard;
import Member.Member;

import java.util.HashMap;
import java.util.Map;

public class CheckoutCounter {

    private Map<Integer, LibraryCard> memberIdLibraryCardMap;

    public CheckoutCounter() {
        memberIdLibraryCardMap = new HashMap<>();
    }

    public Boolean checkoutBook(Book book, Member member) {
        LibraryCard libraryCard = memberIdLibraryCardMap.get(member.getId());
        if (libraryCard == null) {
            libraryCard = createLibraryCard(member);
            memberIdLibraryCardMap.put(member.getId(), libraryCard);
        }
        if (libraryCard.isValid() && book.isAvailable()) {
            book.setCheckedOut();
            libraryCard.addCheckoutEntry(book);
            return true;
        }
        return false;
    }

    private LibraryCard createLibraryCard(Member member) {
        return  new LibraryCard(member);
    }

    public Boolean returnBook(Book book, Member member) {
        if (book.isAvailable()) {
            System.out.printf("Book with ISBN %d isn't showing as checked out%n", book.getIsbn());
            return false;
        }
        if (!memberIdLibraryCardMap.containsKey(member.getId())) {
            System.out.printf("Library Card not found for member with ID %d%n", member.getId());
            return false;
        }
        book.setReturned();
        LibraryCard libraryCard = memberIdLibraryCardMap.get(member.getId());
        libraryCard.markBookAsReturned(book);
        return true;
    }

}
