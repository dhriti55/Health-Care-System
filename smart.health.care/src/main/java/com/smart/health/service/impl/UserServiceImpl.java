package com.smart.health.service.impl;

import com.smart.health.dto.UsersDto;
import com.smart.health.mapper.UsersMapper;
import com.smart.health.repository.UsersRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersMapper usersMapper;

    public UsersDto registerUsers(UsersDto usersDto) throws BadRequestException {
        if(checkExistingUser(usersDto.getEmail())){
            throw new BadRequestException("Email already registered");
        }
        var userDTO = usersMapper.toEntity(usersDto);
        var result = usersRepository.save(userDTO);
        return usersMapper.toDTO(result);
    }

    public String loginUser(UsersDto usersDto) {
        boolean exists = usersRepository.existsByEmail(usersDto.getEmail());
        return exists ? "Logged In Successfully" : "User Doesn't exists! Please Sign Up";
    }

    public boolean checkExistingUser(String email) {
        return usersRepository.existsByEmail(email);
    }

}
