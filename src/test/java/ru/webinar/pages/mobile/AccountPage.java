package ru.webinar.pages.mobile;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static io.appium.java_client.AppiumBy.id;

public class AccountPage {

    SelenideElement
            startMeetingButton = $(id("ru.webinar.mobile:id/btnStartMeeting")),
            avatar = $(id("ru.webinar.mobile:id/avatar")),
            signOutButton = $(id("ru.webinar.mobile:id/btnExit")),
            editProfileButton = $(id("ru.webinar.mobile:id/btnEditProfile")),
            firstNameInput = $(id("ru.webinar.mobile:id/inptFirstName")),
            secondNameInput = $(id("ru.webinar.mobile:id/inptLastName")),
            nicknameInput = $(id("ru.webinar.mobile:id/inptDisplayName")),
            companyInput = $(id("ru.webinar.mobile:id/inptCompany")),
            positionInput = $(id("ru.webinar.mobile:id/inptPosition")),
            phoneInput = $(id("ru.webinar.mobile:id/inptPhone")),
            saveButton = $(id("ru.webinar.mobile:id/btnSave"));

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
    public AccountPage clickSignOut() {
        signOutButton.click();
        return this;
    }

    @Step("Нажать на кнопку Редактировать профиль")
    public AccountPage clickEditProfile() {
        editProfileButton.click();
        return this;
    }

    @Step("Ввести имя")
    public AccountPage setFirstName(String firstName) {
        firstNameInput.click();
        firstNameInput.sendKeys(firstName);
        return this;
    }

    @Step("Ввести фамилию")
    public AccountPage setSecondName(String secondName) {
        secondNameInput.click();
        secondNameInput.sendKeys(secondName);
        return this;
    }

    @Step("Ввести никнейм")
    public AccountPage setNickname(String nickname) {
        nicknameInput.click();
        nicknameInput.sendKeys(nickname);
        return this;
    }

    @Step("Ввести компанию")
    public AccountPage setCompany(String company) {
        companyInput.click();
        companyInput.sendKeys(company);
        return this;
    }

    @Step("Ввести должность")
    public AccountPage setPosition(String position) {
        positionInput.click();
        positionInput.sendKeys(position);
        return this;
    }

    @Step("Ввести телефон")
    public AccountPage setPhone(String phone) {
        phoneInput.click();
        phoneInput.sendKeys(phone);
        return this;
    }

    @Step("Нажать сохранить")
    public AccountPage clickSave() {
        saveButton.click();
        return this;
    }

    @Step("Проверить имя")
    public AccountPage checkFirstName(String firstName) {
        firstNameInput.shouldHave(text(firstName));
        return this;
    }

    @Step("Проверить фамилию")
    public AccountPage checkSecondName(String secondName) {
        secondNameInput.shouldHave(text(secondName));
        return this;
    }

    @Step("Проверить никнейм")
    public AccountPage checkNickname(String nickname) {
        nicknameInput.shouldHave(text(nickname));
        return this;
    }

    @Step("Проверить компанию")
    public AccountPage checkCompany(String company) {
        companyInput.shouldHave(text(company));
        return this;
    }

    @Step("Проверить должность")
    public AccountPage checkPosition(String position) {
        positionInput.shouldHave(text(position));
        return this;
    }

    @Step("Проверить телефон")
    public AccountPage checkPhone(String phone) {
        phoneInput.shouldHave(text(phone));
        return this;
    }
}
