package leveltwo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;


class MapClassTest {
    MapClass testSubject;

    @BeforeEach
    void setUp() {
        testSubject = new MapClass();
    }

    @Test
    @DisplayName("should contain the entries inserted")
    void shouldContainEntriesInserted() {
        testSubject.addToMap("key1", "value1");
        assertThat(testSubject.getMap()).containsKey("key1");
    }

    @Test
    @DisplayName("should contain only the entries inserted")
    void shouldContainOnlyEntriesInserted() {

        testSubject.addToMap("key1", "value1");
        assertThat(testSubject.getMap()).containsOnly(entry("key1", "value1"));
    }

}