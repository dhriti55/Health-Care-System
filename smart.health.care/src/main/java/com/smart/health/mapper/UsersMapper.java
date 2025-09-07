package com.smart.health.mapper;

import com.smart.health.domain.Users;
import com.smart.health.dto.UsersDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsersMapper {

    UsersMapper MAPPER = Mappers.getMapper(UsersMapper.class);

    UsersDto toDTO(Users users);

    Users toEntity(UsersDto usersDto);
}
