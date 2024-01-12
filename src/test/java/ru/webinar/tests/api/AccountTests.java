package ru.webinar.tests.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.webinar.tests.TestData;
import ru.webinar.tests.api.models.account.LoginRequestModel;

import static io.restassured.RestAssured.given;
import static ru.webinar.tests.api.specs.Specs.requestSpec;
import static ru.webinar.tests.api.specs.Specs.responseSpec;

public class AccountTests extends TestBase {

    TestData testData = new TestData();

    @Test
    @Tag("api")
    @DisplayName("Авторизация по почте и паролю")
    void authorizationTest() {
        LoginRequestModel loginRequest = new LoginRequestModel(testData.email, testData.password, true);

        given(requestSpec)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .body(loginRequest.convertToBody())
                .when()
                .post("/login")
                .then()
                .spec(responseSpec)
                .statusCode(200);
    }
}
