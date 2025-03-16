package levelone.tasktwo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DniCharCalculatorTest {

    private static int getDniNumber(ArgumentsAccessor arguments, int testingRemainderEquals) {
        return arguments.getInteger(testingRemainderEquals);
    }

    private static char getDniChar(int testingRemainderEquals) {
        char[] DNI_LETTERS = {
                'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
                'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'
        };
        return DNI_LETTERS[testingRemainderEquals];
    }

    @ParameterizedTest
    @DisplayName("Should generate a specific final character based on remainder to 23")
    @CsvFileSource(resources = "DNI_Numbers_by_Remainder.csv", numLinesToSkip = 1)
    public void ShouldAddSpecificLetterBasedOnRemainder(ArgumentsAccessor arguments) {
        for (int remainder = 0; remainder < 23; remainder++) {
            final int dniNumber = getDniNumber(arguments, remainder);
            char dniChar = getDniChar(remainder);
            String fullDni = DniCharCalculator.generateDNI(dniNumber);
            String expected = String.format("%d%c", dniNumber, dniChar);
            assertEquals(expected, fullDni, "Dni: " + fullDni);
        }


    }

    @Test
    @DisplayName("Should throw an error if the number has more than eight characters")
    public void shouldBeLowerThan100000000() {
        int largeNumber = 100000000;
        assertThrows(IllegalArgumentException.class, () -> DniCharCalculator.generateDNI(largeNumber));
    }
    @Test
    @DisplayName("Should throw an error if the number negative")
    public void shouldBepositiveNumber() {
        int negativeNumber = -1;
        assertThrows(IllegalArgumentException.class, () -> DniCharCalculator.generateDNI(negativeNumber));
    }
    @Test
    @DisplayName("Should throw an error if the number is zero")
    public void shouldNotBeZero() {
        int zero = 0;
        assertThrows(IllegalArgumentException.class, () -> DniCharCalculator.generateDNI(zero));
    }

}