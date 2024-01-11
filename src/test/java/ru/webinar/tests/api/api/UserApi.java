package ru.webinar.tests.api.api;

import ru.webinar.tests.api.models.account.LoginRequestModel;

import static ru.webinar.tests.api.specs.Specs.requestSpec;
import static ru.webinar.tests.api.specs.Specs.responseSpec;
import static io.restassured.RestAssured.given;

public class UserApi {
    public String getSessionId(LoginRequestModel loginRequest) {
        return given(requestSpec)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .body(loginRequest.convertToBody())
                .when()
                .post("/login")
                .then()
                .spec(responseSpec)
                .extract().cookie("sessionId");
    }
}