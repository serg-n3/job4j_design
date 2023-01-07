package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }
    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .contains("second")
                .startsWith("first", "second");
        assertThat(list).element(1).isNotNull()
                .isEqualTo("second");
    }
    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "one", "second", "three", "four", "five", "first", "second");
        assertThat(set).hasSize(6)
                .contains("second")
                .containsAnyOf("zero", "second", "six");
        assertThat(set).filteredOnAssertions(e -> assertThat(e.length()).isLessThan(4))
                .hasSize(1)
                .first().isEqualTo("one");
    }
    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("zero", "first", "second",  "three",  "four");
        assertThat(map).hasSize(5)
                .containsKeys("first", "second",  "three")
                .containsValues(1, 2, 3)
                .doesNotContainKey("six")
                .doesNotContainValue(7)
                .containsEntry("first", 1);
    }

}