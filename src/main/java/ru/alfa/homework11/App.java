package ru.alfa.homework11;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        // 3.1. Проверить InputMismatchException
        Scanner scanner = new Scanner(System.in);
        int countWater = 0;

        try {
            System.out.println("Введите кол-во воды: ");
            countWater = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: нужно было ввести число!");
            scanner.next();
        }

        // 3.2. Проверить своё исключение
        try {
            coffeeMachine.makeCoffee(100);
        } catch (NotEnoughWaterException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка кофемашины завершена");
        }

        // 3.3. Проверить ArithmeticException
        try {
            coffeeMachine.calculateCups(1000, 0);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: размер чашки не может быть 0");
        }

        // 3.4. Проверить NullPointerException
        String nullForCoffeeName = null;
        try {
            coffeeMachine.printCoffeeName(nullForCoffeeName);
        } catch (NullPointerException e) {
            System.out.println("Ошибка: название кофе отсутствует");
        } catch (IOException e) {
            System.out.println("Ошибка IOException для FigletFont.convertOneLine");
        }
    }
}
