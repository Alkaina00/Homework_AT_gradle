package ru.alfa.homework13;

import java.util.Objects;

public class Alien {
    private String name;
    private String planet;
    private int dangerLevel;

    public Alien(String name, String planet, int dangerLevel) {
        this.name = name;
        this.planet = planet;
        setDangerLevel(dangerLevel);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public int getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(int dangerLevel) {
        if (dangerLevel < 1 || dangerLevel > 10) {
            throw new IllegalArgumentException("Уровень опасности должен быть в диапазоне 1-10");
        }
        this.dangerLevel = dangerLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alien alien = (Alien) o;
        return Objects.equals(name, alien.name) &&
                Objects.equals(planet, alien.planet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, planet);
    }

    @Override
    public String toString() {
        return "База данных пришельцев: \n" + "Имя пришельца: " + name + "\nПланета происхождения: " + planet + "\nУровень опасности: " + dangerLevel;
    }
}
