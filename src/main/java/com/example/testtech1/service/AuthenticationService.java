package com.example.testtech1.service;

import com.example.testtech1.model.Article;
import com.example.testtech1.model.User;
import java.util.List;

public interface AuthenticationService {
    User register(String name, int age, List<Article> articles);
}
