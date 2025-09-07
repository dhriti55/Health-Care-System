package com.smart.health.service.impl;

import com.smart.health.dto.AppointmentsDto;
import com.smart.health.mapper.AppointmentMapper;
import com.smart.health.repository.AppointmentsRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppointmentsServiceImpl {

    @Autowired
    AppointmentsRepository appointmentsRepository;

    @Autowired
    AppointmentMapper appointmentMapper;

    @Autowired
    UserServiceImpl userService;


    public String registerNewAppointment(AppointmentsDto appointmentsDto) throws BadRequestException {
        boolean check = userService.checkExistingUser(appointmentsDto.getEmail());
        if(!check){
            throw new BadRequestException("User Doesn't exists. Please Sign up before making an appointment");
        }

        appointmentsRepository.save( appointmentMapper.toEntity(appointmentsDto));
        return "Scheduled appointment successfully!!";
    }

    public List<AppointmentsDto> viewAppointment(){
        var result = appointmentsRepository.findAll();
        return appointmentMapper.toDTOList(result);
    }
}
