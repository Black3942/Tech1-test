package com.example.testtech1.controller;

import com.example.testtech1.dto.response.UserResponseDto;
import com.example.testtech1.service.UserService;
import com.example.testtech1.service.mapper.UserMapper;
import java.util.List;
import java.util.Set;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Api(value = "User Controller", description = "Available end-point for Users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @ApiOperation(value = "View a list of all users")
    @GetMapping
    public List<UserResponseDto> getAll() {
        return userMapper.mapToDtoList(userService.getAll());
    }

    @ApiOperation(value = "View a list of all users with age greater than input value")
    @GetMapping("/by-age")
    public List<UserResponseDto> getByAge(@RequestParam int age) {
        return userMapper.mapToDtoList(userService.getByAge(age));
    }

    @ApiOperation(value = "View a list of all users with input article color")
    @GetMapping("/by-color")
    public Set<UserResponseDto> getByColor(@RequestParam String color) {
        return userMapper.mapToDtoSet(userService.getByColor(color));
    }

    @ApiOperation(value = "View a list of all users who has more than 3 articles")
    @GetMapping("/by-articles")
    public List<String> getByArticles() {
        return userService.getNames();
    }
}
