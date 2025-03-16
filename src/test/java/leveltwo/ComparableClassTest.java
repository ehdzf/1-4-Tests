package leveltwo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


class ComparableClassTest {
    private final String comparableObjectName = "test";
    private ComparableClass comparableObject;
    @BeforeEach
    void setUp() {
        comparableObject = new ComparableClass(comparableObjectName);
    }

    @Test
    @DisplayName("Objects with the same values should compare as equals")
    void taskOneTrueCase() {
        ComparableClass equalObject = new ComparableClass(comparableObjectName);
        assertThat(comparableObject).isEqualTo(equalObject);

    }

    @Test
    @DisplayName("Objects with different values should not compare as equals")
    void taskOneFalseCase() {

        ComparableClass equalObject = new ComparableClass("not equal");
        assertThat(comparableObject).isNotEqualTo(equalObject);

    }

    @Test
    @DisplayName("Objects with the same values should not be same")
    void taskTwoFalseCase() {
        ComparableClass equalObject = new ComparableClass(comparableObjectName);
        assertThat(comparableObject).isNotSameAs(equalObject);

    }

    @Test
    @DisplayName("Objects with the same values should not be same")
    void taskTwoTrueCase() {
        assertThat(comparableObject).isSameAs(comparableObject);

    }

    @Test
    @DisplayName("Two different integer arrays can be compared as identical")
    void taskThree() {
        int[] duplicatedArray = new int[comparableObject.getArray().length];
        for (int i = 0; i < duplicatedArray.length; i++) {
            duplicatedArray[i] = comparableObject.getArray()[i];
        }
        assertThat(comparableObject.getArray()).isEqualTo(duplicatedArray);


    }
    @Test
    @DisplayName("List should store object in the order they are inserted")
    void taskFour() {
        Integer object1 = 12;
        String object2 = object1.toString();
        int[] object3 = comparableObject.getArray();
        comparableObject.insertObjectToList(object1);
        comparableObject.insertObjectToList(object2);
        comparableObject.insertObjectToList(object3);

        assertThat(comparableObject.getObjectList()).containsSequence(object1, object2, object3);
    }
    @Test
    @DisplayName("List should contain all inserted objects regardless of the order")
    void taskFourOne() {
        Integer object1 = 12;
        String object2 = object1.toString();
        int[] object3 = comparableObject.getArray();
        comparableObject.insertObjectToList(object1);
        comparableObject.insertObjectToList(object2);
        comparableObject.insertObjectToList(object3);

        assertThat(comparableObject.getObjectList()).containsExactlyInAnyOrder(object2, object1, object3);
    }
    @Test
    @DisplayName("List should contain only once any object that was inserted once, and must not contain an object that wasn't inserted")
    void taskFourTwo() {
        Integer object1 = 12;
        String object2 = object1.toString();
        int[] object3 = comparableObject.getArray();
        comparableObject.insertObjectToList(object1);
        comparableObject.insertObjectToList(object2);
//        comparableObject.insertObjectToList(object3);

        assertThat(comparableObject.getObjectList()).containsOnlyOnce(object2);
        assertThat(comparableObject.getObjectList()).doesNotContain(object3);
    }
    @Test
    @DisplayName("empty optional instances should be empty")
    void ShouldBeEmptyIfOptionalInstanceWasCreatedEmpty() {
        Optional<ComparableClass> emptyOptional = Optional.empty();
        assertThat(emptyOptional.isEmpty());
    }

}