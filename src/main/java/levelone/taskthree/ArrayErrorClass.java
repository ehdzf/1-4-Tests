package levelone.taskthree;

public class ArrayErrorClass {
    private final int[] array;

    public ArrayErrorClass(int[] array) {
        this.array = new int[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
    }
    public int getByIndex(int index) {
        return array[index];
    }
}
