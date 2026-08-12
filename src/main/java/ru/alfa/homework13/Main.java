package ru.alfa.homework13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Часть 1: База данных пришельцев
        ArrayList<Alien> alienList = new ArrayList<>();

        alienList.add(new Alien("Riko", "Mars", 2));
        alienList.add(new Alien("Riko", "Mars", 5));
        alienList.add(new Alien("Chiko", "Venera", 7));
        alienList.add(new Alien("Mira", "Pluton", 1));
        alienList.add(new Alien("Vanya", "Saturn", 10));

        boolean hasDuplicate = false;
        for (int i = 0; i < alienList.size(); i++) {
            for (int j = i + 1; j < alienList.size(); j++) {
                if (alienList.get(i).equals(alienList.get(j))) {
                    hasDuplicate = true;
                    System.out.println("\nНайден дубликат!");
                    System.out.println("Пришелец 1: " + alienList.get(i));
                    System.out.println("Пришелец 2: " + alienList.get(j));
                    System.out.println("Они считаются одинаковыми, так как имеют одинаковые имя и планету.");
                }
            }
        }

        if(!hasDuplicate)
            System.out.println("\nРезультат: в списке нет дубликатов");


        // Часть 2: Формирование отрядов
        SquadManager squadManager = new SquadManager();
        System.out.println("\n------------ Формирование отрядов ------------");
        squadManager.demonstrateListCreations();

        // Часть 3: Отсеивание трусов
        ArrayList<String> squad = new ArrayList<>();
        squad.add("Анжелика");
        squad.add("Екатерина");
        squad.add("Олеся");
        squad.add("Трус Ваня");
        squad.add("Трус Вася");

        squadManager.filterOutCowards(squad);

        // Часть 4: Очередь на вход
        System.out.println("\n------------ Очередь на вход ------------");
        AssaultQueue assaultQueue = new AssaultQueue();
        assaultQueue.addRecruit("Riko");
        assaultQueue.addRecruit("Chiko");
        assaultQueue.addRecruit("Mira");
        assaultQueue.addRecruit("Miko");
        assaultQueue.addRecruit("Vanya");

        assaultQueue.retreatCoward();
        assaultQueue.retreatCoward();

        assaultQueue.addRecruit("Riko1");
        assaultQueue.addRecruit("Chiko1");
        assaultQueue.addRecruit("Mira1");

        assaultQueue.printQueue();

        // Часть 5: Отчёт командованию
        System.out.println("\n------------ Отчёт командованию ------------");
        List<Alien> capturedAliens = Arrays.asList(new Alien("Riko", "Mars", 2),
                new Alien("Vanya", "Saturn", 10),
                new Alien("Mira", "Pluton", 1));
        MissionReport missionReport = new MissionReport("Штурм Зоны 51", capturedAliens, 50);
        System.out.println(missionReport);

        MissionReport missionReportClone = new MissionReport("Штурм Зоны 51", capturedAliens, 50);
        System.out.println("Сравнение через == - " + (missionReport == missionReportClone));
        System.out.println("Сравнение через equals - " + (missionReport.equals(missionReportClone)));
    }
}
