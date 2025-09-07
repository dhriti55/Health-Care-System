package com.smart.health.controller;

import com.smart.health.dto.AppointmentsDto;
import com.smart.health.service.impl.AppointmentsServiceImpl;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    @Autowired
    AppointmentsServiceImpl appointmentsService;

    @PostMapping("/register")
    public ResponseEntity<String> registerAppointment(@RequestBody AppointmentsDto appointmentsDto) throws BadRequestException {
        var result =  appointmentsService.registerNewAppointment(appointmentsDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentsDto>> viewAppointment() {
        var result =  appointmentsService.viewAppointment();
        return ResponseEntity.ok(result);
    }
}
