package com.example.testtech1.service;

import com.example.testtech1.model.User;
import java.util.List;
import java.util.Set;

public interface UserService {
    User add(User user);

    User get(Long id);

    List<User> getAll();

    List<User> getByAge(int age);

    Set<User> getByColor(String color);

    List<String> getNames();
}
