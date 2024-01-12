package ru.webinar.tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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
    @Severity(SeverityLevel.BLOCKER)
    void createFastMeetingTest() {
        eventPage.openPage("/meetings")
                .clickStartFastMeetingButton()
                .checkPublisherVisible()
                .clickJoinMeetingButton()
                .checkVCSVisible()
                .deleteEvent(sessionId, new DeleteEventRequestModel(false), getEventIdFromUrl(getWebDriver().getCurrentUrl()));
    }

    @Test
    @WithLogin
    @DisplayName("Запуск запланированной встречи")
    @Severity(SeverityLevel.BLOCKER)
    void  createScheduleMeetingTest() {
        eventPage.openPage("/meetings")
                .clickScheduleButton()
                .clickScheduleMeetingButton()
                .clickGoToEventButton()
                .clickStartMeetingButtonButton()
                .checkPublisherVisible()
                .clickJoinMeetingButton()
                .checkVCSVisible()
                .deleteEvent(sessionId, new DeleteEventRequestModel(false), getEventIdFromUrl(getWebDriver().getCurrentUrl()));
    }

    @Test
    @WithLogin
    @DisplayName("Запуск постоянной встречи")
    @Severity(SeverityLevel.BLOCKER)
    void  createScheduleEndlessMeetingTest() {
        eventPage.openPage("/meetings")
                .clickScheduleButton()
                .clickScheduleEndlessMeetingButton()
                .clickGoToEventButton()
                .checkPublisherVisible()
                .clickJoinMeetingButton()
                .checkVCSVisible()
                .deleteEvent(sessionId, new DeleteEventRequestModel(false), getEventIdFromUrl(getWebDriver().getCurrentUrl()));
    }

    @Test
    @WithLogin
    @DisplayName("Нельзя создать встречу без названия")
    @Severity(SeverityLevel.BLOCKER)
    void  errorCreateMeetingWithOutNameTest() {
        eventPage.openPage("/meetings")
                .clickScheduleButton()
                .clickScheduleMeetingButton()
                .clearNameEventInput()
                .clickGoToEventButton()
                .checkErrorNameEventMessage();
    }
}