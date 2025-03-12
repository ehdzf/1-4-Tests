package taskone.library;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import taskone.book.Book;
import taskone.book.BookEntry;

import java.util.List;

class LibraryTest {
    private Library library;

    private Book addNewBookIntoLibrary(String title) {
        Book book = new Book(title);
        library.addBook(book);
        return book;
    }


    @BeforeEach
    void setUp() {
        library = new Library("Test");
    }


    @Test
    @DisplayName("Should have a list after creating a new library")
    public void checkLibraryListExists() {
        assert library.getBooks() != null;
    }

    @Test
    @DisplayName("Should have an empty list after creating a new library")
    public void checkLibraryListIsEmpty() {
        assert library.getBooks().isEmpty();
    }

    @Test
    @DisplayName("Should add any book to an empty library")
    public void addBookToEmptyLibrary() {
        addNewBookIntoLibrary("Test");
        assert library.getBooks().size() == 1;
    }

    @Test
    @DisplayName("Should have 3 items after inserting 3 books")
    void addThreeBooksInLibrary() {
        addNewBookIntoLibrary("Test");
        addNewBookIntoLibrary("Test2");
        addNewBookIntoLibrary("Test3");
        assert library.getBooks().size() == 3;

    }

    @Test
    @DisplayName("Should find a book on its position")
    void shouldFindBookOnPosition() {
        final Book book = addNewBookIntoLibrary("Test");
        assert library.getBooks().get(0).getBook().equals(book);
    }

    @Test
    @DisplayName("Should not have duplicate titles")
    void ShouldHaveUniqueTitles() {
        final String title = "unique title";
        addNewBookIntoLibrary(title);
        addNewBookIntoLibrary(title);

        List<BookEntry> books = library.getBooks().stream().filter(bookEntry -> bookEntry.getBook().getTitle().equals(title)).toList();
        assert books.size() == 1;

    }

    @Test
    @DisplayName("Should be able to obtain the title of a book given its position")
    void obtainBookTitleByPosition() {
        addNewBookIntoLibrary("position 1");
        addNewBookIntoLibrary("position 2");
        addNewBookIntoLibrary("position 3");
        assert library.getBook(2).getTitle().equals("position 3");
    }

    @Test
    @DisplayName("Should decrease the list size by one after deleting a book")
    void decreaseBookSizeByOne() {
        addNewBookIntoLibrary("Test");
        addNewBookIntoLibrary("Test2");
        addNewBookIntoLibrary("Test3");
        assert library.getBooks().size() == 3;
        library.removeBook("Test");
        assert library.getBooks().size() == 2;
    }

    @Test
    @DisplayName("Should be alphabetically by book title")
    void ShouldBeSortedByTitle() {
        addNewBookIntoLibrary("Z");
        addNewBookIntoLibrary("j");
        addNewBookIntoLibrary("0");
        addNewBookIntoLibrary("foo");
        addNewBookIntoLibrary("bar");
        addNewBookIntoLibrary("baz");

        List<BookEntry> books = library.getBooks();

        for (int i = 0; i < books.size() - 1; i++) {
            String currentTitle = books.get(i).getBook().getTitle();
            String nextTitle = books.get(i + 1).getBook().getTitle();
            assert currentTitle.compareToIgnoreCase(nextTitle) < 0 : currentTitle + " should come before " + nextTitle;
        }

    }

    @Test
    @DisplayName("Should be alphabetically by book title after removing a book")
    void ShouldBeSortedByTitleAfterDeletion() {
        addNewBookIntoLibrary("Z");
        addNewBookIntoLibrary("j");
        addNewBookIntoLibrary("0");
        addNewBookIntoLibrary("foo");
        addNewBookIntoLibrary("bar");
        addNewBookIntoLibrary("baz");

        library.removeBook("baz");
        List<BookEntry> books = library.getBooks();

        for (int i = 0; i < books.size() - 1; i++) {
            String currentTitle = books.get(i).getBook().getTitle();
            String nextTitle = books.get(i + 1).getBook().getTitle();
            assert currentTitle.compareToIgnoreCase(nextTitle) < 0 : currentTitle + " should come before " + nextTitle;
        }

    }

}