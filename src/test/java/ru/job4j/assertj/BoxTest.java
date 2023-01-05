package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }
    @Test
    void isThisCube() {
        Box box = new Box(8, 384);
        String name = box.whatsThis();
        assertThat(name).isNotEmpty()
                .isEqualTo("Cube")
                .contains("be");
    }
    @Test
    void is0Vertex() {
        Box box = new Box(0, 10);
        int result = box.getNumberOfVertices();
        assertThat(result).isZero()
                .isLessThan(1)
                .isEqualTo(0);
    }
    @Test
    void is4Vertex() {
        Box box = new Box(4, 10);
        int result = box.getNumberOfVertices();
        assertThat(result).isNotZero()
                .isGreaterThan(3)
                .isLessThan(5)
                .isEqualTo(4);
    }
    @Test
    void isExist() {
        Box box = new Box(4, 10);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }
    @Test
    void isNotExist() {
        Box box = new Box(9, 10);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }
    @Test
    void isAreaTetrahedron() {
        Box box = new Box(4, 2);
        double result = box.getArea();
        assertThat(result).isEqualTo(6.928d, withPrecision(0.001d))
                .isGreaterThan(6.927d)
                .isLessThan(6.930d);
    }
    @Test
    void isAreaUnknown() {
        Box box = new Box(9, 2);
        double result = box.getArea();
        assertThat(result).isEqualTo(0.0d, withPrecision(0.001d))
                .isZero();

    }
}