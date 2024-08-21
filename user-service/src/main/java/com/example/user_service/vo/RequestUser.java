package com.example.user_service.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class RequestUser {
    @NotBlank(message = "Email cannot be null")
    @Size(min=2, message = "Email cannot be less than tow characters")
    @Email
    private String email;

    @NotBlank(message = "Name cannot be null")
    @Size(min = 2, message = "Name cannot be less than tow characters")
    private String name;

    @NotBlank(message = "Password cannot be null")
    @Size(min = 8, message = "password must be equal or bigger than 8 characters")
    private String pwd;

}
