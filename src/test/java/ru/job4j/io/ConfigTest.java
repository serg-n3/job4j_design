package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairCommentAndEmpty() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenValueException() {
        String path = "data/exception.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, config::load);
        assertThat(exception).message();
    }

    @Test
    void whenValueException1() {
        String path = "data/exception1.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, config::load);
        assertThat(exception).message();
    }

    @Test
    void whenValueException2() {
        String path = "data/exception2.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, config::load);
        assertThat(exception).message();
    }
}