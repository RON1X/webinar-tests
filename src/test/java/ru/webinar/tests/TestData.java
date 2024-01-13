package ru.webinar.tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("ru"));

    public final String email = "cyberm4trix@gmail.com", password = "Web1n4rP4ssw0rd";

    public final String
            name = faker.name().firstName(),
            secondName = faker.name().lastName(),
            nickname = faker.name().username(),
            phone = faker.phoneNumber().subscriberNumber(10),
            organization = faker.company().name(),
            position = faker.company().profession(),
            description = "1) Character - " + faker.gameOfThrones().character() +
                    " 2) City - " + faker.gameOfThrones().city() +
                    " 3) Dragon - " + faker.gameOfThrones().dragon() +
                    " 4) House - " + faker.gameOfThrones().house(),
            eventName = faker.cat().name();
}