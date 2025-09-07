package com.smart.health.mapper;

import com.smart.health.domain.Appointments;
import com.smart.health.dto.AppointmentsDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AppointmentMapper {

    AppointmentMapper mapper =  Mappers.getMapper(AppointmentMapper.class);

    Appointments toEntity(AppointmentsDto appointmentsDto);

    AppointmentsDto toDTO(Appointments appointments);

    List<AppointmentsDto> toDTOList(List<Appointments> appointmentsList);
}
