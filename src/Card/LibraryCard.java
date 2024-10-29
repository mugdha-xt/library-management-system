package Card;

import Book.Book;
import Member.Member;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class LibraryCard {

    private Member member;

    private List<Entry> entryList;

    private LocalDate validUntil;

    private Boolean isValid;

    public LibraryCard(Member member) {
        this(member, LocalDate.now());
    }

    public LibraryCard(Member member, LocalDate validUntil) {
        this.member = member;
        this.entryList = new LinkedList<Entry>();
        this.validUntil = validUntil;
        this.isValid = true;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public Boolean isValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public void addCheckoutEntry(Book book) {
        Entry entry = new Entry(book);
        this.entryList.add(entry);
    }

    public void markBookAsReturned(Book book) {
        Entry entry = entryList.stream().filter(e -> e.getBook().getIsbn().equals(book.getIsbn())).findFirst().get();
        entry.markAsReturned();
    }
}
