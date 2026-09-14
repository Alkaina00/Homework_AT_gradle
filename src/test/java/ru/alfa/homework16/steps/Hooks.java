package ru.alfa.homework16.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("========================================");
        System.out.println("НАЧАЛО СЦЕНАРИЯ: " + scenario.getName());
        System.out.println("========================================");
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("========================================");
        if (scenario.isFailed()) {
            System.out.println("СЦЕНАРИЙ ПРОВАЛЕН: " + scenario.getName());
        } else {
            System.out.println("СЦЕНАРИЙ ПРОЙДЕН: " + scenario.getName());
        }
        System.out.println("========================================");
        System.out.println();
    }
}
