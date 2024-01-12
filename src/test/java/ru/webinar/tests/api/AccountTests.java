package ru.webinar.tests.api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.webinar.tests.TestData;
import ru.webinar.tests.api.models.account.LoginRequestModel;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static ru.webinar.tests.api.specs.Specs.requestSpec;
import static ru.webinar.tests.api.specs.Specs.responseSpec;

@Epic("Api")
@Feature("Личный кабинет")
@Tag("api")
public class AccountTests extends TestBase {

    TestData testData = new TestData();

    @Test
    @DisplayName("Авторизация по почте и паролю")
    void authorizationTest() {
        LoginRequestModel loginRequest = new LoginRequestModel(testData.email, testData.password, true);

        step("Авторизоваться по почте и паролю", () ->
                given(requestSpec)
                        .contentType("application/x-www-form-urlencoded; charset=utf-8")
                        .body(loginRequest.convertToBody())
                        .when()
                        .post("/login")
                        .then()
                        .spec(responseSpec)
                        .statusCode(200));
    }
}
