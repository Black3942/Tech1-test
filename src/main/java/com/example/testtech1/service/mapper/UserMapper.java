package com.example.testtech1.service.mapper;

import com.example.testtech1.dto.request.UserRequestDto;
import com.example.testtech1.dto.response.UserResponseDto;
import com.example.testtech1.model.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setName(user.getName());
        responseDto.setAge(user.getAge());
        responseDto.setArticles(user.getArticles());
        return responseDto;
    }

    public User mapToModel(UserRequestDto dto) {
        User user = new User();
        user.setId(user.getId());
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setArticles(dto.getArticles());
        return user;
    }

    public List<UserResponseDto> mapToDtoList(List<User> users) {
        List<UserResponseDto> list = new ArrayList<>();
        users.forEach(u -> list.add(mapToDto(u)));
        return list;
    }

    public Set<UserResponseDto> mapToDtoSet(Set<User> users) {
        Set<UserResponseDto> list = new HashSet<>();
        users.forEach(u -> list.add(mapToDto(u)));
        return list;
    }
}
