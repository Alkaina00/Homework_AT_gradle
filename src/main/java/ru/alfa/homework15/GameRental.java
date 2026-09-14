package ru.alfa.homework15;

import java.util.ArrayList;

public class GameRental {
    ArrayList<BoardGame> catalogGames = new ArrayList<>();

    public void addGame(BoardGame boardGame) {
        if(boardGame == null)
            throw new IllegalArgumentException("Передан null");

        for(BoardGame game: catalogGames) {
            if(game.equals(boardGame))
                throw new IllegalArgumentException("Нельзя добавить дубликат");

            if(game.getName().equals(boardGame.getName()))
                throw new IllegalArgumentException("Нельзя добавить две игры с одинаковым названием");
        }

        catalogGames.add(boardGame);
    }

    public BoardGame searchGame(String name) {
        for(BoardGame game: catalogGames) {
            if(game.getName().equals(name))
                return game;
        }
        return null;
    }

    public boolean rentGame(String name, int customerAge) {
        if(searchGame(name) == null)
            throw new IllegalArgumentException("Игры не существует");

        if(customerAge < searchGame(name).getMinAge())
            return false;

        if(searchGame(name).isRent())
            return false;

        searchGame(name).setRent(true);
        return true;
    }

    public boolean returnGame(String name) {
        if(searchGame(name) == null)
            return false;

        if(!searchGame(name).isRent())
            return false;

        searchGame(name).setRent(false);
        return true;
    }

    public int calculateCost(String name, int days) {
        if(searchGame(name) == null)
            throw new IllegalArgumentException("Игры не существует");
        if(days <= 0)
            throw new IllegalArgumentException("Количество дней меньше или равно нулю");

        return searchGame(name).getPriceRent() * days;
    }

    public void reset() {
        for(BoardGame game: catalogGames) {
            game.setRent(false);
        }
    }
}