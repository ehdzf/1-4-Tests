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
Test class name: DniCharCalculatorTest

 **Goal**: Implement JUnit tests for the `DniCharCalculator` class.
**Description**: This class calculates the letter of a Spanish DNI (National Identity Document) given the number. The DNI number is an 8-digit number followed by a letter. The letter is calculated by dividing the number by 23 and using the remainder to determine the letter from a predefined list of letters.
To get the official algorithm you can visit the [Official Spanish government website](https://www.interior.gob.es/opencms/en/servicios-al-ciudadano/tramites-y-gestiones/dni/calculo-del-digito-de-control-del-nif-nie/)

