package ru.alfa.homework15;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameRentalTest {
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
    void testRentGameNotExist() {
        System.out.println("TEST");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> gameRental.rentGame("Уничтожение", 10),
                "Метод должен выбросить IllegalArgumentException, если игры не существует"
        );
    }

    @Test
    void testRentGameNotAge() {
        System.out.println("TEST");

        gameRental.addGame(new BoardGame("Султанат", 10, 1500));

        assertFalse(gameRental.rentGame("Султанат", 8), "Метод должен вернуть false, если клиент " +
                "не подходит по возрасту");
    }

    @Test
    void testRentGame() {
        System.out.println("TEST");

        gameRental.addGame(new BoardGame("Взрывные котики", 10, 1500));
        gameRental.rentGame("Взрывные котики", 10);

        assertFalse(gameRental.rentGame("Взрывные котики", 10), "Метод должен вернуть false, если игра уже арендована");
    }

    @Test
    void testRentGameHappyPathTrue() {
        System.out.println("TEST");

        gameRental.addGame(new BoardGame("Призрак", 10, 1500));
        gameRental.rentGame("Призрак", 10);

        assertTrue(gameRental.searchGame("Призрак").isRent(), "Метод должен отметить игру как арендованную и вернуть true, если аренда разрешена");
    }

    @Test
    void testReturnGameNotExist() {
        System.out.println("TEST");

        assertFalse(gameRental.returnGame("Уничтожение2"), "Метод должен вернуть false, если игры не существует");
    }

    @Test
    void testReturnGameNotRent() {
        System.out.println("TEST");

        gameRental.addGame(new BoardGame("Семья", 10, 1500));

        assertFalse(gameRental.returnGame("Семья"), "Метод должен вернуть false, игра не была арендована");
    }

    @Test
    void testReturnGameHappyPath() {
        System.out.println("TEST");

        gameRental.addGame(new BoardGame("Зомби!", 10, 1500));
        gameRental.rentGame("Зомби!", 10);

        assertTrue(gameRental.returnGame("Зомби!"), "Метод должен вернуть true, игра была арендована");
    }
}