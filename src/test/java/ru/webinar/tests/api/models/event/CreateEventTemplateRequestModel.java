package ru.webinar.tests.api.models.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateEventTemplateRequestModel {

    String name;
    AccessSettingsModel accessSettings;

    @Data
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AccessSettingsModel {
        Boolean isPasswordRequired, isRegistrationRequired, isModerationRequired;
    }
}
