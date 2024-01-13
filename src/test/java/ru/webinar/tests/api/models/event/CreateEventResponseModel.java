package ru.webinar.tests.api.models.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateEventResponseModel {
    String name, type, status;
}
