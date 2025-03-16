package levelone.tasktwo;

public class DniCharCalculator {
    private static final char[] DNI_LETTERS = {
            'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
            'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'
    };

    public static String generateDNI(int dniNumber) {
        if (!isNumberLargerThanEightDigits(dniNumber) || !isNumberLargerGreaterThanZero(dniNumber)) {
            throw new IllegalArgumentException("DNI must be an 8-digit number.");
        }
        return dniNumber + String.valueOf(DNI_LETTERS[dniNumber % 23]);
    }

    private static boolean isNumberLargerThanEightDigits(int dniNumber) {
        return  dniNumber <= 99999999;
    }
    private static boolean isNumberLargerGreaterThanZero(int dniNumber) {
        return  dniNumber > 0;
    }
}
