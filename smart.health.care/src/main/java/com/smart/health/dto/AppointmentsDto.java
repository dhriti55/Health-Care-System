package com.smart.health.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

import java.time.LocalDate;
@Data
public class AppointmentsDto {

    private Long appointmentId;

    @Email
    private String email;

    private LocalDate dateTime;

    private String description;

}
