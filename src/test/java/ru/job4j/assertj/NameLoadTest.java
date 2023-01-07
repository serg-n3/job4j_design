package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }
    @Test
    void parseIsEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");
    }
    @Test
    void isStartsWith() {
        NameLoad nameLoad = new NameLoad();
        String name = "=ivan";
        assertThatThrownBy(() -> nameLoad.parse(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: %s does not contain a key", name)
                .hasMessageContaining(name)
                .hasMessageContaining("name");
    }
    @Test
    void isContains() {
        NameLoad nameLoad = new NameLoad();
        String name = "ivan";
        assertThatThrownBy(() -> nameLoad.parse(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: %s does not contain the symbol \"=\"", name)
                .hasMessageContaining(name)
                .hasMessageContaining("name");
    }
    @Test
    void isIndexOf() {
        NameLoad nameLoad = new NameLoad();
        String name = "ivan=";
        assertThatThrownBy(() -> nameLoad.parse(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: %s does not contain a value", name)
                .hasMessageContaining(name)
                .hasMessageContaining("name");
    }
}