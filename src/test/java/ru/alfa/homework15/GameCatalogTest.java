package ru.alfa.homework15;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GameCatalogTest {
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
    void testAddGameNull() {
        System.out.println("TEST");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> gameRental.addGame(null),
                "Передача null должна приводить к IllegalArgumentException"
        );
    }

    @Test
    void testAddGameSameName() {
        System.out.println("TEST");

        BoardGame boardGame = new BoardGame("Название", 8, 1000);
        gameRental.addGame(boardGame);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> gameRental.addGame(new BoardGame("Название", 6, 500)),
                "Добавлены две игры с одинаковым названием"
        );
    }

    @Test
    void testAddGameDuplicate() {
        System.out.println("TEST");

        gameRental.addGame(new BoardGame("Название", 6, 500));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> gameRental.addGame(new BoardGame("Название", 6, 500)),
                "При добавлении дубликата не вызвалось исключения"
        );
    }

    @Test
    void testSearchGameHappyPath() {
        System.out.println("TEST");

        BoardGame boardGame = new BoardGame("Монополия", 10, 1500);
        gameRental.addGame(boardGame);

        assertEquals(boardGame, gameRental.searchGame("Монополия"), "Метод поиска не нашел игру по названию!");
    }

    @Test
    void testSearchGameHappyPathNull() {
        System.out.println("TEST");
        assertNull(gameRental.searchGame("Развод По Русски"), "Метод поиска не нашел игру по названию!");
    }
}