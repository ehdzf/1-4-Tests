# Testing.

⚙ To run all tests:

- ``` bash
  mvn test
  ```

## Level 1 : JUnit:

### 📚 Libraries:

- org.junit.jupiter:junit-jupiter:5.4.11

### ✅ Task one:

Package name: main.java.levelone
Class name: Library
Test package name: test.java.levelone
Test class name: library.LibraryTest

**Goal**: Implement JUnit tests for the `Library` class.

This class represents a library that can store books. The library has the following methods:

- `addBook(Book book)`: Adds a book to the library.
- `removeBook(Book book)`: Removes a book from the library.
- `getBook(int position)`: Gets a book from the library by its position.
- `getBooks()`: Returns a list of all books in the library sorted alphabetically by book title.

#### Tests:

    - **checkLibraryListExists**: Verifies that the library's book list is initialized and not null after creating a new library.
    - **checkLibraryListIsEmpty**: Ensures that the library's book list is empty after creating a new library.
    - **addBookToEmptyLibrary**: Tests that a book can be added to an empty library and the list size becomes 1.
    - **addThreeBooksInLibrary**: Confirms that adding three books to the library results in a list size of 3.
    - **shouldFindBookOnPosition**: Checks that a book can be found at its correct position in the library.
    - **ShouldHaveUniqueTitles**: Ensures that the library does not allow duplicate book titles.
    - **obtainBookTitleByPosition**: Verifies that the title of a book can be obtained given its position in the library.
    - **decreaseBookSizeByOne**: Tests that removing a book from the library decreases the list size by one.
    - **ShouldBeSortedByTitle**: Ensures that the books in the library are sorted alphabetically by title.
    - **ShouldBeSortedByTitleAfterDeletion**: Confirms that the books remain sorted alphabetically by title even after a book is removed.

### ✅ Task two:

Package name: leveltwo
Class name: DniCharCalculator
Test package name: test.java.leveltwo
Test class names: DniCharCalculatorTest, MapClassTest

**Goal**: implement assertions using AssertJ library.
**Description**: Classes were created to test different situations, like equality, sorting order, etc.

#### Tests:

    - **Objects with the same values should compare as equals:** Verifies that two ComparableClass objects with the same values are considered equal.
    - **Objects with different values should not compare as equals:** Ensures that two ComparableClass objects with different values are not considered equal.
    - **Objects with the same values should not be same:** Confirms that two ComparableClass objects with the same values are not the same instance.
    - **Two different integer arrays can be compared as identical:** Checks that two different integer arrays with the same values are considered equal.
    - **List should store object in the order they are inserted:** Verifies that the list in ComparableClass stores objects in the order they are inserted.
    - **List should contain all inserted objects regardless of the order:** Ensures that the list in ComparableClass contains all inserted objects, regardless of the order.
    - **List should contain only once any object that was inserted once, and must not contain an object that wasn't inserted:** Confirms that the list in ComparableClass contains each inserted object only once and does not contain objects that were not inserted.
    - **empty optional instances should be empty:** Verifies that an empty Optional instance is indeed empty.
