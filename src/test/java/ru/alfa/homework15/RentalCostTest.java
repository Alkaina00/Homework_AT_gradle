package ru.alfa.homework15;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalCostTest {
    GameRental gameRental;

    @BeforeEach
    public void setUp() {
        System.out.println("setUp");
        gameRental = new GameRental();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    void testCalculateCostNotExist() {
        System.out.println("TEST");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> gameRental.calculateCost("Кромби", 10),
                "Метод должен выбросить IllegalArgumentException, если игры не существует"
        );
    }

    @Test
    void testCalculateCostDay() {
        System.out.println("TEST");

        gameRental.addGame(new BoardGame("Кромби", 10, 100));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> gameRental.calculateCost("Кромби", -1),
                "Метод должен выбросить IllegalArgumentException, если количество дней меньше нуля"
        );
    }

    @Test
    void testCalculateCostDay0() {
        System.out.println("TEST");

        gameRental.addGame(new BoardGame("Кромби2", 10, 100));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> gameRental.calculateCost("Кромби2", 0),
                "Метод должен выбросить IllegalArgumentException, если количество дней равно нулю"
        );
    }

    @Test
    void testCalculateCostHappyPath() {
        System.out.println("TEST");

        gameRental.addGame(new BoardGame("Жромби", 10, 100));

        assertEquals(1000, gameRental.calculateCost("Жромби", 10), "Метод должен вернуть значение по формуле - 1000");
    }
}