package com.example.user_service.vo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestLogin {
    @NotNull(message = "Email cannot be null")
    @Size(min = 2, message = "Email must not be less than tow characters")
    private String email;

    @NotNull(message = "password cannot be null")
    @Size(min = 8, message = "password must be equals or grater than 8 characters")
    private String password;
}
