package ru.alfa.homework20.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.alfa.homework20.steps.CalculatorSteps;

public class FailDemoTest {
    private final CalculatorSteps steps = new CalculatorSteps();

    @Test
    @DisplayName("Демонстрация FAIL: корень из 16 (намеренно неверное ожидание)")
    @Story("Корень")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Alina")
    @Description("Намеренно падающий тест, чтобы показать в отчёте FAIL с шагами и вложениями")
    public void testDemoFail() {
        double result = steps.sqrt(16);
        steps.verifyResult(result, 999);
    }
}
