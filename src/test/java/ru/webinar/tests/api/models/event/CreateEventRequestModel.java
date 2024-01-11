package ru.webinar.tests.api.models.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateEventRequestModel {
    String startAt;
    Integer maxParticipationSettings;
    Boolean quick;
    String createMethod;
    CreateEventTemplateRequestModel.AccessSettingsModel accessSettings;
}
