package taskone.book;

import java.util.Objects;

public class BookEntry {
    private final Book book;
    private final int position;

    public BookEntry(Book book, int position) {
        this.book = book;
        this.position = position;
    }

    public Book getBook() {
        return book;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookEntry bookEntry = (BookEntry) o;
        return getPosition() == bookEntry.getPosition() && Objects.equals(getBook(), bookEntry.getBook());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBook(), getPosition());
    }

    @Override
    public String toString() {
        return "BookEntry{" +
                "book=" + book +
                ", position=" + position +
                '}';
    }
}
