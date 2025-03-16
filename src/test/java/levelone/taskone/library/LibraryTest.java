package levelone.taskone.library;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import levelone.taskone.book.Book;
import levelone.taskone.book.BookEntry;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        assertNotEquals(null, library.getBooks());
    }

    @Test
    @DisplayName("Should have an empty list after creating a new library")
    public void checkLibraryListIsEmpty() {
        assertTrue(library.getBooks().isEmpty());
    }

    @Test
    @DisplayName("Should add any book to an empty library")
    public void addBookToEmptyLibrary() {
        addNewBookIntoLibrary("Test");
        assertEquals(1, library.getBooks().size());
    }

    @Test
    @DisplayName("Should have 3 items after inserting 3 books")
    void addThreeBooksInLibrary() {
        addNewBookIntoLibrary("Test");
        addNewBookIntoLibrary("Test2");
        addNewBookIntoLibrary("Test3");
        assertEquals(3, library.getBooks().size());

    }

    @Test
    @DisplayName("Should find a book on its position")
    void shouldFindBookOnPosition() {
        final Book book = addNewBookIntoLibrary("Test");
        assertEquals(book, library.getBooks().get(0).getBook());
    }

    @Test
    @DisplayName("Should not have duplicate titles")
    void ShouldHaveUniqueTitles() {
        final String title = "unique title";
        addNewBookIntoLibrary(title);
        addNewBookIntoLibrary(title);

        List<BookEntry> books = library.getBooks().stream().filter(bookEntry -> bookEntry.getBook().getTitle().equals(title)).toList();
        assertEquals(1, books.size());

    }

    @Test
    @DisplayName("Should be able to obtain the title of a book given its position")
    void obtainBookTitleByPosition() {
        addNewBookIntoLibrary("position 1");
        addNewBookIntoLibrary("position 2");
        addNewBookIntoLibrary("position 3");
        assertEquals("position 3", library.getBook(2).getTitle());
    }

    @Test
    @DisplayName("Should decrease the list size by one after deleting a book")
    void decreaseBookSizeByOne() {
        addNewBookIntoLibrary("Test");
        addNewBookIntoLibrary("Test2");
        addNewBookIntoLibrary("Test3");
        assertEquals(3, library.getBooks().size());
        library.removeBook("Test");
        assertEquals(2, library.getBooks().size());
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
            assertTrue(currentTitle.compareToIgnoreCase(nextTitle) < 0);
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
            assertTrue(currentTitle.compareToIgnoreCase(nextTitle) < 0);
        }

    }

}