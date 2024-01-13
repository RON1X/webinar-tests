package ru.webinar.pages.mobile;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class StartScreenPage {

    private final SelenideElement
            openAuthorizationButton = $(id("ru.webinar.mobile:id/btnSignIn")),
            openAuthorizationWithSsoButton = $(id("ru.webinar.mobile:id/btnSsoSignIn")),
            openRegistrationButton = $(id("ru.webinar.mobile:id/btnSignUp")),
            emailInput = $(id("ru.webinar.mobile:id/inptEmail")),
            passwordInput = $(id("ru.webinar.mobile:id/inptPassword")),
            signInButton = $(id("ru.webinar.mobile:id/btnSignIn"));

    @Step("Нажать кнопку Войти")
    public StartScreenPage clickOpenAuthorizationButton() {
        openAuthorizationButton.click();
        return this;
    }

    @Step("Ввести почту")
    public StartScreenPage setEmail(String email) {
        emailInput.click();
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Ввести пароль")
    public StartScreenPage setPassword(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Нажать кнопку Войти")
    public StartScreenPage clickSignIn() {
        signInButton.click();
        return this;
    }

    @Step("Проверить видимость кнопки Войти")
    public StartScreenPage checkOpenAuthorizationButtonVisible() {
        openAuthorizationButton.shouldHave(visible);
        return this;
    }

    @Step("Проверить видимость кнопки Войти через SSO")
    public StartScreenPage checkOpenAuthorizationWithSsoButtonVisible() {
        openAuthorizationWithSsoButton.shouldHave(visible);
        return this;
    }

    @Step("Проверить видимость кнопки Зарегистрироваться")
    public StartScreenPage checkOpenRegistrationButtonVisible() {
        openRegistrationButton.shouldHave(visible);
        return this;
    }
}