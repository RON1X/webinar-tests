package ru.webinar.tests.api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.webinar.tests.TestData;
import ru.webinar.tests.api.api.EventApi;
import ru.webinar.tests.api.api.UserApi;
import ru.webinar.tests.api.models.account.LoginRequestModel;
import ru.webinar.tests.api.models.account.UserDataResponseModel;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static ru.webinar.tests.api.specs.Specs.requestSpec;
import static ru.webinar.tests.api.specs.Specs.responseSpec;

@Epic("Api")
@Feature("Личный кабинет")
@Tag("api")
public class AccountTests extends TestBase {

    EventApi eventApi = new EventApi();
    UserApi userApi = new UserApi();
    TestData testData = new TestData();
    LoginRequestModel loginRequest = new LoginRequestModel(testData.email, testData.password, true);
    String sessionId = userApi.getSessionId(loginRequest);

    @Test
    @DisplayName("Авторизация по почте и паролю")
    @Severity(SeverityLevel.BLOCKER)
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

    @Test
    @DisplayName("Получение информацию об авторизованном пользователе")
    @Severity(SeverityLevel.BLOCKER)
    void getUserDataTest() {
        step("Получить информацию об авторизованном пользователе", () ->
                given(requestSpec)
                        .cookie("sessionId", sessionId)
                        .contentType("application/x-www-form-urlencoded; charset=utf-8")
                        .when()
                        .post("/logout")
                        .then()
                        .spec(responseSpec)
                        .statusCode(204));
    }
}
