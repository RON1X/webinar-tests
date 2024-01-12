package ru.webinar.pages.web;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage extends PageBase {

    SelenideElement
            nameInput = $(byName("name")),
            secondNameInput = $(byName("secondName")),
            nicknameInput = $(byName("nickname")),
            phoneInput = $(byName("phone")),
            organizationInput = $(byName("organization")),
            positionInput = $(byName("position")),
            descriptionInput = $(byName("description")),
            saveButton = $(byText("Сохранить"));

    @Step("Указать имя")
    public ProfilePage setName(String name) {
        cleanInput(nameInput);
        nameInput.setValue(name);
        return this;
    }

    @Step("Указать фамилию")
    public ProfilePage setSecondName(String secondName) {
        cleanInput(secondNameInput);
        secondNameInput.setValue(secondName);
        return this;
    }

    @Step("Указать никнейм")
    public ProfilePage setNickname(String nickname) {
        cleanInput(nicknameInput);
        nicknameInput.setValue(nickname);
        return this;
    }

    @Step("Указать телефон")
    public ProfilePage setPhone(String phone) {
        cleanInput(phoneInput);
        phoneInput.setValue(phone);
        return this;
    }

    @Step("Указать организацию")
    public ProfilePage setOrganization(String organization) {
        cleanInput(organizationInput);
        organizationInput.setValue(organization);
        return this;
    }

    @Step("Указать должность")
    public ProfilePage setPosition(String position) {
        cleanInput(positionInput);
        positionInput.setValue(position);
        return this;
    }

    @Step("Указать информацию о себе")
    public ProfilePage setDescription(String description) {
        cleanInput(descriptionInput);
        descriptionInput.setValue(description);
        return this;
    }

    @Step("Нажать кнопку Сохранить")
    public void clickSave() {
        saveButton.click();
    }

    @Step("Проверить что указанная информация сохранилась")
    public void checkSuccessfulChangeProfileData(String name, String secondName, String nickname, String phone, String organization, String position, String description) {
        nameInput.shouldHave(value(name));
        secondNameInput.shouldHave(value(secondName));
        nicknameInput.shouldHave(value(nickname));
        phoneInput.shouldHave(value(phone));
        organizationInput.shouldHave(value(organization));
        positionInput.shouldHave(value(position));
        descriptionInput.shouldHave(value(description));
    }
}
