package ru.alfa.homework9;

import com.github.lalyos.jfiglet.FigletFont;
import net.datafaker.Faker;

import java.util.Random;

public class Logo {

    public static void main(String[] args) throws Exception {
        // Часть 1. Название-Логотип
        String lastNames[] = {"Ivanov", "Sergeev", "Miroeva", "Tutkin", "Shishkina"};
        Faker faker = new Faker();

        System.out.println(FigletFont.convertOneLine(randomLastName(lastNames)));
        System.out.println(FigletFont.convertOneLine("&"));
        System.out.println(FigletFont.convertOneLine(faker.name().lastName()));

        // Часть 2. Генерилка юр данных для регистрации
        System.out.println(faker.name().fullName());
        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.address().fullAddress());
    }

    public static String randomLastName(String[] array) {
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }
}