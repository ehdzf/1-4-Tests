package levelone.taskthree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayErrorClassTest {
    private final int[] testArray = {1, 2, 3, 4, 5};
    private ArrayErrorClass arrayErrorClass;

    @BeforeEach
    void setUp() {
        arrayErrorClass = new ArrayErrorClass(testArray);
    }

    @Test
    @DisplayName("should throw 'ArrayIndexOutOfBoundsException' if called an out of bounds index")
    public void testArrayIndexOutOfBoundsException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, ( )-> arrayErrorClass.getByIndex(testArray.length));

    }

}