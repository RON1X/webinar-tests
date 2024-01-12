package ru.webinar.tests.web;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import ru.webinar.pages.web.AuthorizationPage;
import ru.webinar.pages.web.ProfilePage;
import ru.webinar.pages.web.ToolbarPage;
import ru.webinar.tests.TestData;
import ru.webinar.tests.api.extensions.WithLogin;
import org.junit.jupiter.api.Test;

@Epic("Web")
@Feature("Личный кабинет")
@Tag("web")
public class AccountTest extends TestBase {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    ToolbarPage toolbarPage = new ToolbarPage();
    ProfilePage profilePage = new ProfilePage();

    TestData testData = new TestData();

    @Test
    @DisplayName("Авторизация по почте и паролю")
    @Severity(SeverityLevel.BLOCKER)
    void authorizationTest() {
        authorizationPage.openPage("/signin")
                .setEmail(testData.email)
                .setPassword(testData.password)
                .clickSubmit()
                .checkSuccessfulAuthorization();
    }

    @Test
    @WithLogin
    @DisplayName("Изменение информации в профиле")
    @Severity(SeverityLevel.NORMAL)
    void changeProfileDataTest() {
        toolbarPage.openPage("/meetings")
                .clickAvatar()
                .clickProfile();

        profilePage.setName(testData.name)
                .setSecondName(testData.secondName)
                .setNickname(testData.nickname)
                .setPhone(testData.phone)
                .setOrganization(testData.organization)
                .setPosition(testData.position)
                .setDescription(testData.description)
                .clickSave();

        toolbarPage.clickAvatar()
                .clickProfile();

        profilePage.checkSuccessfulChangeProfileData(testData.name, testData.secondName, testData.nickname, testData.phone, testData.organization, testData.position, testData.description);
    }

    @Test
    @WithLogin
    @DisplayName("Выход из аккаунта")
    @Severity(SeverityLevel.CRITICAL)
    void logoutTest() {
        toolbarPage.openPage("/meetings")
                .clickAvatar()
                .clickLogout()
                .checkSuccessfulLogout();
    }
}