package ru.webinar.pages.mobile;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class AccountPage {

    SelenideElement
            startMeetingButton = $(id("ru.webinar.mobile:id/btnStartMeeting")),
            avatar = $(id("ru.webinar.mobile:id/avatar")),
            signOutButton = $(id("ru.webinar.mobile:id/btnExit"));

    @Step("Проверить видимость кнопки Создать встречу")
    public AccountPage checkStartMeetingButtonVisible() {
        startMeetingButton.shouldHave(visible);
        return this;
    }

    @Step("Нажать на аватар")
    public AccountPage clickAvatar() {
        avatar.click();
        return this;
    }

    @Step("Нажать на кнопку Выйти")
    public AccountPage clickSignOutButton() {
        signOutButton.click();
        return this;
    }
}
