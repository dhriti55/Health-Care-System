package com.smart.health.controller;

import com.smart.health.dto.UsersDto;
import com.smart.health.service.impl.UserServiceImpl;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<UsersDto> registerNewUsers(@RequestBody UsersDto usersDto) throws BadRequestException {
        var result =  userService.registerUsers(usersDto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UsersDto usersDto) {
        var result =  userService.loginUser(usersDto);
        return ResponseEntity.ok(result);
    }
}
