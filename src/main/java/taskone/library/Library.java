package taskone.library;

import taskone.book.Book;
import taskone.book.BookEntry;

import java.util.*;

public class Library {
    private final Set<BookEntry> books = new HashSet<>();
    private final String name;
    private int nextPositionCounter = 0;

    public Library(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        boolean exists = !books.stream().filter(bookEntry -> bookEntry.getBook().equals(book)).toList().isEmpty();
        if (!exists) {
            BookEntry entry = new BookEntry(book, nextPositionCounter++);
            if (!books.add(entry)) {
                throw new IllegalArgumentException(
                        "Duplicate name already exists in the library");
            }
        }
    }

    public void addBook(Book book, int position) {
        BookEntry entry = new BookEntry(book, position);
        if (!books.add(entry)) {
            throw new IllegalArgumentException(
                "Duplicate name or position already exists in the library");
        }
    }

    public Book getBook(int position) {
        Book book = null;
        for (BookEntry entry : books) {
            if (entry.getPosition() == position) {
                book = entry.getBook();
            }
        }
        return book;
    }

    public List<BookEntry> getBooks() {
        List<BookEntry> bookEntries = new ArrayList<>(books);
        bookEntries.sort(Comparator.comparing(entry -> entry.getBook().getTitle().toLowerCase()));
        return bookEntries;
    }

    public void removeBook(String title) {
        books.removeIf(e -> e.getBook().getTitle().equals(title));
    }


}
