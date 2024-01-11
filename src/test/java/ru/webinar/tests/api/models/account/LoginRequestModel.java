package ru.webinar.tests.api.models.account;

import lombok.Data;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequestModel {
    private String email, password;
    Boolean rememberMe;

    public String convertToBody() {
        return "email=" + email + "&password=" + password + "&rememberMe=" + rememberMe;
    }
}
