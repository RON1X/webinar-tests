package ru.webinar.pages.web;

import com.codeborne.selenide.SelenideElement;

import static org.openqa.selenium.Keys.*;

public abstract class PageBase {
    void cleanInput(SelenideElement input) {
        input.sendKeys(HOME, chord(SHIFT, END), BACK_SPACE);
    }
}
