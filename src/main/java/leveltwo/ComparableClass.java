package leveltwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ComparableClass {
    private final String name;
    private final int[] array;
    private final ArrayList<Object> objectList = new ArrayList<>();

    public ComparableClass(String name) {
        this.name = name;
        this.array = new int[]{1, 2, 3, 4, 5, 6};
    }

    public String getName() {
        return this.name;
    }

    public int[] getArray() {
        return array;
    }
    public ArrayList<Object> getObjectList() {
        return objectList;
    }
    public void insertObjectToList(Object object) {
        objectList.add(object);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ComparableClass that = (ComparableClass) o;
        return Objects.equals(getName(), that.getName()) && Objects.deepEquals(getArray(), that.getArray());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), Arrays.hashCode(getArray()));
    }
}
