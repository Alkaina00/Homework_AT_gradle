package ru.alfa.homework14.part1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("Интерстеллар", 8.7));
        movies.add(new Movie("Шрек", 8.1));
        movies.add(new Movie("Начало", 8.8));
        movies.add(new Movie("Веном", 6.6));

        System.out.println("------Список фильмов до сортировки------");
        for(Movie movie: movies) {
            System.out.println(movie);
        }

        movies.sort(new MovieRatingComparator());

        System.out.println("\n------Список фильмов после сортировки------");
        for(Movie movie: movies) {
            System.out.println(movie);
        }
    }
}
