package ru.webinar.pages.web;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationPage {

    SelenideElement
            emailInput = $(byName("email")),
            passwordInput = $(byName("password")),
            submitButton = $(byAttribute("data-testid", "SignIn.action.submit")),
            profileImage = $(byAttribute("data-testid", "Meetings.PageTopbar.User"));

    @Step("Открыть страницу")
    public AuthorizationPage openPage(String url) {
        open(url);
        return this;
    }

    @Step("Указать email")
    public AuthorizationPage setEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Указать пароль")
    public AuthorizationPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Нажать кнопку Войти")
    public AuthorizationPage clickSubmit() {
        submitButton.click();
        return this;
    }

    @Step("Проверить что пользователь попал в личный кабинет")
    public void checkSuccessfulAuthorization() {
        profileImage.shouldHave(visible);
    }
}