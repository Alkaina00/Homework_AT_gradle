package ru.alfa.homework19;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AuthenticationTest {
    @Test
    public void userCanLoginAndLogout() {
        Selenide.open("https://the-internet.herokuapp.com/");
        $("a[href='/login']").click();

        SelenideElement header = $("h2");
        header.shouldHave(text("Login Page"));

        $("#username").setValue("tomsmith");
        $("#password").setValue("SuperSecretPassword!");
        $("button[type='submit']").click();

        $("#flash").shouldHave(text("You logged into a secure area!"));
        $("a[href='/logout']").shouldBe(visible);
        $("a[href='/logout']").click();

        $("h2").shouldHave(text("Login Page"));

        Selenide.closeWebDriver();
    }

    @Test
    public void userCanLoginAdmin() {
        Selenide.open("https://the-internet.herokuapp.com/");
        $("a[href='/login']").click();

        SelenideElement elementalSelenium = $x("//*[@id=\"page-footer\"]/div/div/a");
        elementalSelenium.shouldHave(text("Elemental Selenium"));

        $("#username").setValue("admin");
        $("#password").setValue("1234");
        $("button[type='submit']").click();

        $("#flash").shouldHave(text("Your username is invalid!"));

        Selenide.closeWebDriver();
    }
}
