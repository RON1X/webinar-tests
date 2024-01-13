package ru.webinar.pages.web;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ToolbarPage {

    private final SelenideElement
            emailInput = $(byName("email")),
            passwordInput = $(byName("password")),
            submitButton = $(byAttribute("data-testid", "SignIn.action.submit")),
            profileImage = $(byAttribute("data-testid", "Meetings.PageTopbar.User")),
            profileButton = $(byAttribute("data-testid", "Meetings.PageTopbar.User.profile")),
            logoutButton = $(byAttribute("data-testid", "Meetings.PageTopbar.User.logout"));

    @Step("Открыть страницу")
    public ToolbarPage openPage(String url) {
        open(url);
        return this;
    }

    @Step("Кликнуть по аватарке")
    public ToolbarPage clickAvatar() {
        profileImage.click();
        return this;
    }

    @Step("Нажать на кнопку Профиль")
    public ToolbarPage clickProfile() {
        profileButton.click();
        return this;
    }

    @Step("Нажать на кнопку Выход")
    public ToolbarPage clickLogout() {
        logoutButton.click();
        return this;
    }

    @Step("Проверить что пользователь вышел из аккаунта")
    public void checkSuccessfulLogout() {
        emailInput.shouldHave(visible);
        passwordInput.shouldHave(visible);
        submitButton.shouldHave(visible);
        webdriver().shouldHave(url("https://my.mts-link.ru/signin"));
    }
}
