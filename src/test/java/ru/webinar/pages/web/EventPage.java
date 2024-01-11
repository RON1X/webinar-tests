package ru.webinar.pages.web;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.webinar.tests.api.api.EventApi;
import ru.webinar.tests.api.models.event.DeleteEventRequestModel;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class EventPage {

    EventApi eventApi = new EventApi();

    SelenideElement
            startFastMeetingButton = $(byAttribute("data-testid", "Meetings.Toolbar.startMeeting")),
            publisher = $(byId("prepare-vcs")),
            joinMeetingButton = $(byText("Присоединиться к встрече")),
            vcs = $(byAttribute("data-testid", "Stream.Vcs.MyConference"));

    @Step("Открыть страницу")
    public EventPage openPage(String url) {
        open(url);
        return this;
    }

    @Step("Нажать кнопку Быстрая встреча")
    public EventPage clickStartFastMeetingButton() {
        startFastMeetingButton.click();
        return this;
    }

    @Step("Проверить отображение паблишера")
    public EventPage checkPublisherVisible() {
        publisher.shouldHave(visible);
        return this;
    }

    @Step("Нажать кнопку Присоединиться к встрече")
    public EventPage clickJoinMeetingButton() {
        joinMeetingButton.click();
        return this;
    }

    @Step("Проверить отображение своей ВКС")
    public EventPage checkVCSVisible() {
        vcs.shouldHave(visible);
        return this;
    }

    @Step("Удалить мероприятие")
    public void deleteEvent(String sessionId, DeleteEventRequestModel deleteEventRequest, String eventId) {
        eventApi.deleteEvent(sessionId, deleteEventRequest, eventId);
    }
}