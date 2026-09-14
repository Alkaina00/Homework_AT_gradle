package ru.alfa.homework20.tests;

import ru.alfa.homework20.steps.CalculatorSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Калькулятор")
@Feature("Арифметические операции")
public class ArithmeticTest {

    private final CalculatorSteps steps = new CalculatorSteps();

    @Test
    @DisplayName("Сложение двух положительных чисел")
    @Story("Сложение")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Alina")
    @Description("Проверяем базовое сложение двух положительных чисел: 2 + 3 должно дать 5")
    public void testAddPositiveNumbers() {
        Allure.parameter("a", 2);
        Allure.parameter("b", 3);
        double result = steps.add(2, 3);
        steps.verifyResult(result, 5);
    }

    @Test
    @DisplayName("Сложение с отрицательным числом")
    @Story("Сложение")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверяем, что калькулятор корректно обрабатывает сложение с отрицательным числом")
    public void testAddWithNegative() {
        double result = steps.add(-5, 3);
        steps.verifyResult(result, -2);
    }

    @Test
    @DisplayName("Вычитание")
    @Story("Вычитание")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Alina")
    public void testSubtraction() {
        double result = steps.subtract(10, 4);
        steps.verifyResult(result, 6);
    }

    @Test
    @DisplayName("Умножение")
    @Story("Умножение")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяем умножение 7 на 8, ожидаемый результат 56")
    public void testMultiplication() {
        double result = steps.multiply(7, 8);
        steps.verifyResult(result, 56);
    }

    @Test
    @DisplayName("Деление")
    @Story("Деление")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "ТЗ на деление", url = "https://example.com/divide-spec")
    public void testDivision() {
        double result = steps.divide(15, 3);
        steps.verifyResult(result, 5);
    }

    @Test
    @DisplayName("Деление на ноль — ожидается исключение")
    @Story("Деление")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Alina")
    @Link(name = "Bugs", url = "https://example.com/CALC-101")
    public void testDivideByZero() {
        Allure.step("Делим 10 на 0 и ожидаем ArithmeticException");
        org.junit.jupiter.api.Assertions.assertThrows(
                ArithmeticException.class,
                () -> steps.divide(10, 0)
        );
    }
}