package ru.webinar.tests.api.api;

import ru.webinar.tests.api.models.event.CreateEventRequestModel;
import ru.webinar.tests.api.models.event.CreateEventTemplateRequestModel;
import ru.webinar.tests.api.models.event.DeleteEventRequestModel;

import static io.restassured.RestAssured.given;
import static ru.webinar.tests.api.specs.Specs.requestSpec;
import static ru.webinar.tests.api.specs.Specs.responseSpec;

public class EventApi {
    public String getEventId(String sessionId, CreateEventTemplateRequestModel createEventTemplateRequest) {
        return given(requestSpec)
                .cookie("sessionId", sessionId)
                .contentType("application/json")
                .body(createEventTemplateRequest)
                .when()
                .post("/event")
                .then()
                .spec(responseSpec)
                .extract().path("id").toString();
    }

    public void createEvent(String sessionId, CreateEventRequestModel createEventRequest, String eventId) {
        given(requestSpec)
                .cookie("sessionId", sessionId)
                .contentType("application/json")
                .body(createEventRequest)
                .when()
                .post("/event/" + eventId + "/session")
                .then()
                .spec(responseSpec)
                .statusCode(201);
    }

    public void deleteEvent(String sessionId, DeleteEventRequestModel deleteEventRequest, String eventId) {
        given(requestSpec)
                .cookie("sessionId", sessionId)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body(deleteEventRequest.convertToBody())
                .when()
                .delete("/event/" + eventId)
                .then()
                .spec(responseSpec)
                .statusCode(204);
    }
}