package ru.geekbrains.main.site.at.example.junit.annotaions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Параметризованные тесты")
public class ParameterizedExampleTest {

    @DisplayName("пример хардкода данных")
    @ParameterizedTest
    @ValueSource(strings = {"Hello", "World"})
    void hardcode(String name) {
        System.out.println(name);
        assertTrue(true);
    }

    @DisplayName("пример получения данных из метода")
    @ParameterizedTest
    @MethodSource("stringProvider")
    void method(String name) {
        System.out.println(name);
        assertTrue(true);
    }

    static Stream<String> stringProvider() {
        return Stream.of(
                "Hello",
                "World");
    }

    @ParameterizedTest
    @MethodSource("stringAndIntProvider")
    void testWithMultiArgMethodSource(String first, int second) {
        assertNotNull(first);
        assertNotEquals(0, second);
    }

    static Stream<Arguments> stringAndIntProvider() {
        return Stream.of(
                Arguments.of("foo", 1),
                Arguments.of("bar", 2));
    }

}
