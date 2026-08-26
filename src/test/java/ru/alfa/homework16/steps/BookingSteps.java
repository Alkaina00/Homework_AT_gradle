package ru.alfa.homework16.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class BookingSteps {
    @Given("в ресторане есть столик с номером {int} вместимостью {int}")
    public void createTable(int num, int capacity) {
        System.out.println("Добавлен столик №" + num + " вместимостью " + capacity);
    }

//    @Given("в ресторане есть столик с номером {string} вместимостью {string}")
//    public void createTable(String num, String capacity) {
//        System.out.println("Добавлен столик №" + num + " вместимостью " + capacity);
//    }

    @When("гость бронирует столик на {int} человека и {int} время")
    public void reservTable(int count, int time) {
        System.out.println("Гость бронирует столик на " + count + " человек на время " + time);
    }

    @Then("бронирование успешно создано")
    public void reservExecute() {
        System.out.println("Бронирование успешно создано");
    }

    @Then("бронирование успешно отклонено")
    public void reservRejected() {
        System.out.println("Бронирование отклонено");
    }

    @Then("бронирование успешно {string}")
    public void reservResult(String result) {
        if ("создано".equals(result)) {
            System.out.println("Бронирование успешно создано");
        } else if ("отклонено".equals(result)) {
            System.out.println("Бронирование отклонено");
        } else {
            System.out.println("Результат бронирования: " + result);
        }
    }

    @When("гость отменяет своё бронирование")
    public void reservCancel() {
        System.out.println("Гость отменяет бронирование");
    }

    @Then("бронирование успешно отменено")
    public void reservCancelExecute() {
        System.out.println("Бронирование успешно отменено");
    }

//    Блок 4
    @Given("в ресторане есть столики:")
    public void createTables(DataTable table) {
        System.out.println("Добавлены столики");
        List<Map<String,String>> rows = table.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            String num = row.get("номер");
            String capacity = row.get("вместимость");
            System.out.println("Столик №" + num + " вместимостью " + capacity);
        }
    }

    //    Блок 5
    @When("гость оставляет пожелание к брони:")
    public void bookingRequest(String jsonBody) {
        System.out.println("===== Пожелание клиента =====");
        System.out.println(jsonBody);
        System.out.println("=============================");
    }
}
