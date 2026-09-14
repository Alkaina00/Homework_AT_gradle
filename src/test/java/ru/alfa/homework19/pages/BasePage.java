package ru.alfa.homework19.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    private static final String BASE_URL = "https://the-internet.herokuapp.com/";
    private final SelenideElement loginLink = $("a[href='/login']");

    public BasePage open() {
        Selenide.open(BASE_URL);
        return this;
    }

    public LoginPage goToLoginPage() {
        loginLink.click();
        return new LoginPage();
    }
}
