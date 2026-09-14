package ru.alfa.homework19;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import ru.alfa.homework19.pages.BasePage;
import ru.alfa.homework19.pages.LoginPage;

public class AuthenticationTest {

    @Test
    public void userCanLoginAndLogout() {
        LoginPage loginPage = new BasePage().open().goToLoginPage();

        loginPage.headerContains("Login Page")
                .loginAs("tomsmith", "SuperSecretPassword!")
                .flashMessageContains("You logged into a secure area!")
                .logoutButtonVisible()
                .logout()
                .headerContains("Login Page");

        Selenide.closeWebDriver();
    }

    @Test
    public void userCanLoginAdmin() {
        LoginPage loginPage = new BasePage().open().goToLoginPage();

        loginPage.elementalSeleniumLinkContains("Elemental Selenium")
                .loginWithInvalidCredentials("admin", "1234")
                .flashMessageContains("Your username is invalid!");

        Selenide.closeWebDriver();
    }
}