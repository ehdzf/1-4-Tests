package leveltwo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapClass {
    private Map<String, String> map;
    public MapClass( ) {
        map = new HashMap<>();
    }

    public Map<String, String> getMap() {
        return map;
    }
    public void addToMap(String key, String value) {
        map.put(key, value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MapClass mapClass = (MapClass) o;
        return Objects.equals(getMap(), mapClass.getMap());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getMap());
    }

    @Override
    public String toString() {
        return "MapClass{" +
                "map=" + map +
                '}';
    }
}
