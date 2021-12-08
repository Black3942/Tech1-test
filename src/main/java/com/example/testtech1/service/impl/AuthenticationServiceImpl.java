package com.example.testtech1.service.impl;

import com.example.testtech1.model.Article;
import com.example.testtech1.model.User;
import com.example.testtech1.service.AuthenticationService;
import com.example.testtech1.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;

    public AuthenticationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User register(String name, int age, List<Article> articles) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setArticles(articles);
        return userService.add(user);
    }
}
