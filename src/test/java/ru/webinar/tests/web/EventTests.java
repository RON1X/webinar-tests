package ru.webinar.tests.web;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import ru.webinar.pages.web.EventPage;
import ru.webinar.tests.TestData;
import ru.webinar.tests.api.api.UserApi;
import ru.webinar.tests.api.extensions.WithLogin;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Epic;
import ru.webinar.tests.api.models.account.LoginRequestModel;
import ru.webinar.tests.api.models.event.DeleteEventRequestModel;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ru.webinar.utils.Helpers.getEventIdFromUrl;

@Epic("Web")
@Feature("Быстрая встреча")
@Tag("web")
public class EventTests extends TestBase {

    UserApi userApi = new UserApi();
    TestData testData = new TestData();
    LoginRequestModel loginRequest = new LoginRequestModel(testData.email, testData.password, true);
    String sessionId = userApi.getSessionId(loginRequest);

    EventPage eventPage = new EventPage();

    @Test
    @WithLogin
    @DisplayName("Запуск быстрой встречи")
    void createFastMeetingTest() {
        eventPage.openPage("/meetings")
                .clickStartFastMeetingButton()
                .checkPublisherVisible()
                .clickJoinMeetingButton()
                .checkVCSVisible()
                .deleteEvent(sessionId, new DeleteEventRequestModel(false), getEventIdFromUrl(getWebDriver().getCurrentUrl()));
    }
}
