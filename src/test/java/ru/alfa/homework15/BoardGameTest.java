package ru.alfa.homework15;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardGameTest {
    BoardGame boardGame;

    @BeforeEach
    public void setUp() {
        System.out.println("setUp");
        boardGame = new BoardGame("Название", 6, 500);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("tearDown");
    }

    @ParameterizedTest
    @MethodSource("boardGameStream")
    public void testValidInvalidName(String name, int minAge, int priceRent, String assertErrorMessage) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BoardGame(name, minAge, priceRent),
                assertErrorMessage
        );
    }

    static Stream<Arguments> boardGameStream() {
        return Stream.of(
                Arguments.arguments(null, 6, 500, ""),
                Arguments.arguments("", 6, 500, ""),
                Arguments.arguments("Название", -1, 500, ""),
                Arguments.arguments("Название", 6, -1, ""),
                Arguments.arguments("Название", 6, 0, "")
        );
    }

    @ParameterizedTest
    @CsvSource({
            ", 6, 500, Имя не может быть null",
            "'', 6, 500, Имя не может быть пустым",
            "Название, -1, 500, Возраст не может быть меньше 0",
            "Название, 6, -1, Цена не может быть отрицательной",
            "Название, 6, 0, Цена должна быть больше 0"
    })
    public void testValidInvalidNameCsv(String name, int minAge, int priceRent, String assertErrorMessage) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BoardGame(name, minAge, priceRent),
                assertErrorMessage
        );
    }

    @Test
    void testCanBeRentedByTrue() {
        System.out.println("TEST");

        int age = 6;

        boolean resultActual = boardGame.canBeRentedBy(age);
        boolean resultExpected = true;

        assertEquals(resultExpected, resultActual, "Результат проверки возраста - false, а не true!");
    }

    @Test
    void testCanBeRentedByFalse() {
        System.out.println("TEST");

        int age = 5;

        boolean resultActual = boardGame.canBeRentedBy(age);
        boolean resultExpected = false;

        assertEquals(resultExpected, resultActual, "Результат проверки возраста - true, а не false!");
    }
}