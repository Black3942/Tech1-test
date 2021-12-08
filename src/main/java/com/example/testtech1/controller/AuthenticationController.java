package com.example.testtech1.controller;

import com.example.testtech1.dto.request.UserRequestDto;
import com.example.testtech1.dto.response.UserResponseDto;
import com.example.testtech1.service.AuthenticationService;
import com.example.testtech1.service.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Auth Controller", description = "Available end-point to register Users")
public class AuthenticationController {
    private final AuthenticationService authService;
    private final UserMapper userMapper;

    public AuthenticationController(AuthenticationService authService, UserMapper userMapper) {
        this.authService = authService;
        this.userMapper = userMapper;
    }

    @ApiOperation(value = "Register a new User")
    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto dto) {
        return userMapper.mapToDto(authService.register(dto.getName(), dto.getAge(), dto.getArticles()));
    }
}
