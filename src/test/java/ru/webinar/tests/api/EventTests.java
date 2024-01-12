package ru.webinar.tests.api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import ru.webinar.tests.TestData;
import ru.webinar.tests.api.api.EventApi;
import ru.webinar.tests.api.api.UserApi;
import ru.webinar.tests.api.models.event.CreateEventRequestModel;
import ru.webinar.tests.api.models.event.CreateEventTemplateRequestModel;
import ru.webinar.tests.api.models.event.DeleteEventRequestModel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.webinar.tests.api.models.account.LoginRequestModel;

import static io.qameta.allure.Allure.step;
import static ru.webinar.tests.api.specs.Specs.requestSpec;
import static ru.webinar.tests.api.specs.Specs.responseSpec;
import static io.restassured.RestAssured.given;

@Epic("Api")
@Feature("Мероприятия")
@Tag("api")
public class EventTests extends TestBase {

    EventApi eventApi = new EventApi();
    UserApi userApi = new UserApi();
    TestData testData = new TestData();
    LoginRequestModel loginRequest = new LoginRequestModel(testData.email, testData.password, true);
    String sessionId = userApi.getSessionId(loginRequest);

    @Test
    @DisplayName("Создание шаблона для мероприятия")
    @Severity(SeverityLevel.BLOCKER)
    void createEventTemplateTest() {
        CreateEventTemplateRequestModel.AccessSettingsModel accessSettings = new CreateEventTemplateRequestModel.AccessSettingsModel(false, false, false);
        CreateEventTemplateRequestModel createEventTemplateRequest = new CreateEventTemplateRequestModel("New Event", accessSettings);

        step("Создать шаблон для мероприятия", () ->
                given(requestSpec)
                        .cookie("sessionId", sessionId)
                        .contentType("application/json")
                        .body(createEventTemplateRequest)
                        .when()
                        .post("/event")
                        .then()
                        .spec(responseSpec)
                        .statusCode(201));
    }

    @Test
    @DisplayName("Создание быстрой встречи")
    @Severity(SeverityLevel.BLOCKER)
    void createEventTest() {
        CreateEventTemplateRequestModel.AccessSettingsModel accessSettings = new CreateEventTemplateRequestModel.AccessSettingsModel(false, false, false);
        CreateEventTemplateRequestModel createEventTemplateRequest = new CreateEventTemplateRequestModel("New Event", accessSettings);
        CreateEventRequestModel createEventRequest = new CreateEventRequestModel("2023-11-02T11:06:04+0300", 100, true, "google_calendar", accessSettings);
        DeleteEventRequestModel deleteEventRequest = new DeleteEventRequestModel(false);

        String eventId = step("Создать шаблон для быстрой встречи", () ->
                eventApi.getEventId(sessionId, createEventTemplateRequest));

        step("Создать быструю встречу", () ->
                given(requestSpec)
                        .cookie("sessionId", sessionId)
                        .contentType("application/json")
                        .body(createEventRequest)
                        .when()
                        .post("/event/"+eventId+"/session")
                        .then()
                        .spec(responseSpec)
                        .statusCode(201));

        step("Удалить быструю встречу", () ->
                eventApi.deleteEvent(sessionId, deleteEventRequest, eventId));
    }

    @Test
    @DisplayName("Удаление мероприятия")
    @Severity(SeverityLevel.CRITICAL)
    void deleteEvent() {
        CreateEventTemplateRequestModel.AccessSettingsModel accessSettings = new CreateEventTemplateRequestModel.AccessSettingsModel(false, false, false);
        CreateEventTemplateRequestModel createEventTemplateRequest = new CreateEventTemplateRequestModel("New Event", accessSettings);
        CreateEventRequestModel createEventRequest = new CreateEventRequestModel("2023-11-02T11:06:04+0300", 100, true, "google_calendar", accessSettings);
        DeleteEventRequestModel deleteEventRequest = new DeleteEventRequestModel(false);

        String eventId = step("Создать шаблон для мероприятия", () ->
                eventApi.getEventId(sessionId, createEventTemplateRequest));

        step("Создать мероприятие", () ->
                eventApi.createEvent(sessionId, createEventRequest, eventId));

        step("Удалить мероприятие", () ->
                given(requestSpec)
                        .cookie("sessionId", sessionId)
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .body(deleteEventRequest.convertToBody())
                        .when()
                        .delete("/event/"+eventId)
                        .then()
                        .spec(responseSpec)
                        .statusCode(204));
    }
}