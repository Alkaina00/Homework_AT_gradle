package ru.alfa.homework20.steps;

import ru.alfa.homework20.Calculator;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class CalculatorSteps {

    private final Calculator calculator = new Calculator();

    private void attachCalculation(double a, String op, double b, double result) {
        Allure.addAttachment("Вычисление", "text/plain",
                String.format("%s %s %s = %s", a, op, b, result));
    }

    @Step("Сложить {a} + {b}")
    public double add(double a, double b) {
        double result = calculator.add(a, b);
        attachCalculation(a, "+", b, result);
        return result;
    }

    @Step("Вычесть {a} - {b}")
    public double subtract(double a, double b) {
        double result = calculator.subtract(a, b);
        attachCalculation(a, "-", b, result);
        return result;
    }

    @Step("Умножить {a} * {b}")
    public double multiply(double a, double b) {
        double result = calculator.multiply(a, b);
        attachCalculation(a, "*", b, result);
        return result;
    }

    @Step("Разделить {a} / {b}")
    public double divide(double a, double b) {
        double result = calculator.divide(a, b);
        attachCalculation(a, "/", b, result);
        return result;
    }

    @Step("Возвести {base} в степень {exponent}")
    public double power(double base, double exponent) {
        double result = calculator.power(base, exponent);
        attachCalculation(base, "**", exponent, result);
        return result;
    }

    @Step("Извлечь корень из {value}")
    public double sqrt(double value) {
        double result = calculator.sqrt(value);
        Allure.addAttachment("Корень", "text/plain",
                String.format("sqrt(%s) = %s", value, result));
        return result;
    }

    @Step("Проверить, что результат равен {expected}")
    public void verifyResult(double actual, double expected) {
        Assertions.assertEquals(expected, actual, 1e-9,
                String.format("Ожидалось %s, получено %s", expected, actual));
    }
}