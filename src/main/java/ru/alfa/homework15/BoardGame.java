package ru.alfa.homework15;

import java.util.Objects;

public class BoardGame {
    private String name;
    private int minAge;
    private int priceRent;
    private boolean rent;

    public BoardGame(String name, int minAge, int priceRent) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Некорректные данные Названия при создании объекта!");
        }
        this.name = name;

        if(minAge < 0){
            throw new IllegalArgumentException("Некорректные данные Минимального возраста при создании объекта!");
        }
        this.minAge = minAge;

        if(priceRent <= 0){
            throw new IllegalArgumentException("Некорректные данные Минимального возраста при создании объекта!");
        }
        this.priceRent = priceRent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getPriceRent() {
        return priceRent;
    }

    public void setPriceRent(int priceRent) {
        this.priceRent = priceRent;
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    public boolean canBeRentedBy(int age) {
        return age >= minAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardGame boardGame = (BoardGame) o;
        return Objects.equals(name, boardGame.name) &&
                Objects.equals(minAge, boardGame.minAge) &&
                Objects.equals(priceRent, boardGame.priceRent);
    }
}