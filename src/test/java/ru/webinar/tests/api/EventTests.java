package ru.webinar.tests.api;

import ru.webinar.tests.TestData;
import ru.webinar.tests.api.api.EventApi;
import ru.webinar.tests.api.api.UserApi;
import ru.webinar.tests.api.models.event.CreateEventRequestModel;
import ru.webinar.tests.api.models.event.CreateEventTemplateRequestModel;
import ru.webinar.tests.api.models.event.DeleteEventRequestModel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.webinar.tests.api.models.account.LoginRequestModel;

import static ru.webinar.tests.api.specs.Specs.requestSpec;
import static ru.webinar.tests.api.specs.Specs.responseSpec;
import static io.restassured.RestAssured.given;

public class EventTests extends TestBase {

    EventApi eventApi = new EventApi();
    UserApi userApi = new UserApi();
    TestData testData = new TestData();
    LoginRequestModel loginRequest = new LoginRequestModel(testData.email, testData.password, true);
    String sessionId = userApi.getSessionId(loginRequest);

    @Test
    @Tag("api")
    void createEventTemplateTest() {
        CreateEventTemplateRequestModel.AccessSettingsModel accessSettings = new CreateEventTemplateRequestModel.AccessSettingsModel(false, false, false);
        CreateEventTemplateRequestModel createEventTemplateRequest = new CreateEventTemplateRequestModel("New Event", accessSettings);

        given(requestSpec)
                .cookie("sessionId", sessionId)
                .contentType("application/json")
                .body(createEventTemplateRequest)
                .when()
                .post("/event")
                .then()
                .spec(responseSpec)
                .statusCode(201);
    }

    @Test
    @Tag("api")
    void createEventTest() {
        CreateEventTemplateRequestModel.AccessSettingsModel accessSettings = new CreateEventTemplateRequestModel.AccessSettingsModel(false, false, false);
        CreateEventTemplateRequestModel createEventTemplateRequest = new CreateEventTemplateRequestModel("New Event", accessSettings);
        CreateEventRequestModel createEventRequest = new CreateEventRequestModel("2023-11-02T11:06:04+0300", 100, true, "google_calendar", accessSettings);
        DeleteEventRequestModel deleteEventRequest = new DeleteEventRequestModel(false);

        String eventId = eventApi.getEventId(sessionId, createEventTemplateRequest);

        given(requestSpec)
                .cookie("sessionId", sessionId)
                .contentType("application/json")
                .body(createEventRequest)
                .when()
                .post("/event/"+eventId+"/session")
                .then()
                .spec(responseSpec)
                .statusCode(201);

        eventApi.deleteEvent(sessionId, deleteEventRequest, eventId);
    }

    @Test
    @Tag("api")
    void deleteEvent() {
        CreateEventTemplateRequestModel.AccessSettingsModel accessSettings = new CreateEventTemplateRequestModel.AccessSettingsModel(false, false, false);
        CreateEventTemplateRequestModel createEventTemplateRequest = new CreateEventTemplateRequestModel("New Event", accessSettings);
        CreateEventRequestModel createEventRequest = new CreateEventRequestModel("2023-11-02T11:06:04+0300", 100, true, "google_calendar", accessSettings);
        DeleteEventRequestModel deleteEventRequest = new DeleteEventRequestModel(false);

        String eventId = eventApi.getEventId(sessionId, createEventTemplateRequest);

        eventApi.createEvent(sessionId, createEventRequest, eventId);

        given(requestSpec)
                .cookie("sessionId", sessionId)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body(deleteEventRequest.convertToBody())
                .when()
                .delete("/event/"+eventId)
                .then()
                .spec(responseSpec)
                .statusCode(204);
    }
}
