package ru.alfa.homework19.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SecureAreaPage {
    private final SelenideElement flash = $("#flash");
    private final SelenideElement logoutButton = $("a[href='/logout']");

    public SecureAreaPage flashMessageContains(String expectedText) {
        flash.shouldHave(text(expectedText));
        return this;
    }

    public SecureAreaPage logoutButtonVisible() {
        logoutButton.shouldBe(visible);
        return this;
    }

    public LoginPage logout() {
        logoutButton.click();
        return new LoginPage();
    }
}
