package com.smart.health.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UsersDto {

    private Long userId;

    @NotBlank
    private String name;

    @Email
    private String email;

    private String password;
}
