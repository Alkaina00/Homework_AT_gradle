package ru.alfa.homework14.part1;

public class Movie {
    private String name;
    private double rating;

    public Movie(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "Название: " + name + "\nРейтинг: " + rating;
    }
}
