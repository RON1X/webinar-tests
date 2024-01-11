package ru.webinar.tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "https://my.mts-link.ru";
        RestAssured.basePath = "/api";
    }
}
