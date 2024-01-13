package ru.webinar.tests.mobile;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.webinar.pages.mobile.AccountPage;
import ru.webinar.pages.mobile.StartScreenPage;
import ru.webinar.tests.TestData;

import static io.qameta.allure.Allure.step;

@Epic("Android")
@Feature("Личный кабинет")
@Tag("android")
public class AccountTests extends TestBase {

    StartScreenPage startScreenPage = new StartScreenPage();
    AccountPage accountPage = new AccountPage();

    TestData testData = new TestData();

    @Test
    @DisplayName("Авторизация по почте и паролю")
    @Severity(SeverityLevel.BLOCKER)
    void authorizationTest() {
        startScreenPage.clickOpenAuthorizationButton()
                .setEmail(testData.email)
                .setPassword(testData.password)
                .clickSignIn();

        accountPage.checkStartMeetingButtonVisible();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Severity(SeverityLevel.CRITICAL)
    void signOutTest() {
        startScreenPage.clickOpenAuthorizationButton()
                .setEmail(testData.email)
                .setPassword(testData.password)
                .clickSignIn();

        accountPage.clickAvatar()
ad                .clickSignOut();

        startScreenPage
                .checkOpenAuthorizationButtonVisible()
                .checkOpenAuthorizationWithSsoButtonVisible()
                .checkOpenRegistrationButtonVisible();
    }

    @Test
    @DisplayName("Редактирование профиля")
    @Severity(SeverityLevel.CRITICAL)
    void editProfileTest() {
        startScreenPage.clickOpenAuthorizationButton()
                .setEmail(testData.email)
                .setPassword(testData.password)
                .clickSignIn();

        accountPage.clickAvatar()
                .clickEditProfile()
                .setFirstName(testData.name)
                .setSecondName(testData.secondName)
                .setNickname(testData.nickname)
                .setCompany(testData.organization)
                .setPosition(testData.position)
                .setPhone(testData.phone)
                .clickSave()
                .clickEditProfile()
                .checkFirstName(testData.name)
                .checkSecondName(testData.secondName)
                .checkNickname(testData.nickname)
                .checkCompany(testData.organization)
                .checkPosition(testData.position)
                .checkPhone(testData.phone);
    }
}
