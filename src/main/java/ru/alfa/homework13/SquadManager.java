package ru.alfa.homework13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SquadManager {
    public void demonstrateListCreations() {
        ArrayList<String> squadMain = new ArrayList<>();
        squadMain.add("Миша");
        squadMain.add("Саша");
        squadMain.add("Игорь");
        squadMain.add("Павел");

        List<String> squadSupport = Arrays.asList("Афоня", "Мирон", "Георгий");

        List<String> squadElita = List.of("Владимир", "Константин");

        try {
            squadMain.add("Новинка");
            System.out.println("Основной отряд, успешное добавление!");
            squadMain.remove(0);
            System.out.println("Основной отряд, успешное удаление!");
        } catch (Exception e) {
            System.out.println("Возникла ошибка! Основной отряд: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        try {
            squadSupport.add("Ибрагиииим");
            System.out.println("Отряд поддержки, успешное добавление!");
            squadSupport.remove(0);
            System.out.println("Отряд поддержки, успешное удаление!");
        } catch (Exception e) {
            System.out.println("Возникла ошибка! Отряд поддержки: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        try {
            squadElita.add("Сулейман");
            System.out.println("Элитный отряд, успешное добавление!");
            squadElita.remove(0);
            System.out.println("Элитный отряд, успешное удаление!");
        } catch (Exception e) {
            System.out.println("Возникла ошибка! Элитный отряд: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    public void filterOutCowards(List<String> squad) {
        System.out.println("\nОтряд до фильтрации: ");
        for(String name: squad) {
            System.out.println(name);
        }

        Iterator<String> iterator = squad.iterator();
        while(iterator.hasNext()) {
            String name = iterator.next();

            if(name.startsWith("Трус")) {
                iterator.remove();
            }
        }

        System.out.println("\nОтряд после фильтрации: ");
        for(String name: squad) {
            System.out.println(name);
        }
    }
}
