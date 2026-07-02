package ru.alfa.homework11;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

public class CoffeeMachine {

    public void makeCoffee(int countWatterMll) {
        if(countWatterMll < 200)
            throw new NotEnoughWaterException("Недостаточно воды для приготовления кофе. Текущий объем: " +
                    countWatterMll + "мл, необходимо 200мл");
        else
            System.out.println("Кофе приготовлен");
    }

    public void calculateCups(int countWatterMll, int valueCup) {
        int countCup = countWatterMll / valueCup;
        System.out.printf("Можно приготовить %d чашек кофе%n", countCup);
    }

    public void printCoffeeName(String nameCoffee) throws IOException {
        if(nameCoffee == null)
            throw new NullPointerException("Название кофе отсутствует");
        else
            System.out.println(FigletFont.convertOneLine(nameCoffee));
    }
}
