package ru.webinar.tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.webinar.pages.mobile.AccountPage;
import ru.webinar.pages.mobile.StartScreenPage;
import ru.webinar.tests.TestData;

@Tag("android")
public class AccountTests extends TestBase {

    StartScreenPage startScreenPage = new StartScreenPage();
    AccountPage accountPage = new AccountPage();

    TestData testData = new TestData();

    @Test
    @DisplayName("Авторизация по почте и паролю")
    void authorizationTest() {
        startScreenPage.clickOpenAuthorizationButton()
                .setEmail(testData.email)
                .setPassword(testData.password)
                .clickSignIn();

        accountPage.checkStartMeetingButtonVisible();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    void signOutTest() {
        startScreenPage.clickOpenAuthorizationButton()
                .setEmail(testData.email)
                .setPassword(testData.password)
                .clickSignIn();

        accountPage.clickAvatar()
                .clickSignOutButton();

        startScreenPage
                .checkOpenAuthorizationButtonVisible()
                .checkOpenAuthorizationWithSsoButtonVisible()
                .checkOpenRegistrationButtonVisible();
    }
}
