package ru.alfa.homework20.tests;

import ru.alfa.homework20.steps.CalculatorSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Калькулятор")
@Feature("Математические функции")
public class MathFunctionsTest {

    private final CalculatorSteps steps = new CalculatorSteps();

    @Test
    @DisplayName("Возведение в степень")
    @Story("Степень")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Alina")
    @Description("Проверяем возведение 2 в степень 10, ожидаемый результат 1024")
    public void testPower() {
        double result = steps.power(2, 10);
        steps.verifyResult(result, 1024);
    }

    @Test
    @DisplayName("Квадратный корень из отрицательного числа — ожидается исключение")
    @Story("Корень")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяем, что извлечение квадратного корня из отрицательного числа выбрасывает ArithmeticException")
    public void testSqrtOfNegative() {
        Allure.step("Извлекаем корень из -16 и ожидаем ArithmeticException");
        org.junit.jupiter.api.Assertions.assertThrows(
                ArithmeticException.class,
                () -> steps.sqrt(-16)
        );
    }
}