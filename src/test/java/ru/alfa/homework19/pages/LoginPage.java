package ru.alfa.homework19.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement header = $("h2");
    private final SelenideElement username = $("#username");
    private final SelenideElement password = $("#password");
    private final SelenideElement loginButton = $("button[type='submit']");
    private final SelenideElement flash = $("#flash");
    private final SelenideElement elementalSeleniumLink = $x("//*[@id='page-footer']/div/div/a");

    public LoginPage headerContains(String expectedText) {
        header.shouldHave(text(expectedText));
        return this;
    }

    public LoginPage elementalSeleniumLinkContains(String expectedText) {
        elementalSeleniumLink.shouldHave(text(expectedText));
        return this;
    }

    public SecureAreaPage loginAs(String user, String pass) {
        username.setValue(user);
        password.setValue(pass);
        loginButton.click();
        return new SecureAreaPage();
    }

    public LoginPage loginWithInvalidCredentials(String user, String pass) {
        username.setValue(user);
        password.setValue(pass);
        loginButton.click();
        return new LoginPage();
    }

    public LoginPage flashMessageContains(String expectedText) {
        flash.shouldHave(text(expectedText));
        return this;
    }
}
