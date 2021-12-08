package com.example.testtech1.service.impl;

import com.example.testtech1.model.Color;
import com.example.testtech1.model.User;
import com.example.testtech1.repository.UserRepository;
import com.example.testtech1.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User add(User user) {
        return repository.save(user);
    }

    @Override
    public User get(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public List<User> getByAge(int age) {
        return repository.findByAgeGreaterThan(age);
    }

    @Override
    public Set<User> getByColor(String color) {
        return new HashSet<>(repository.findByArticlesIsContaining(Color
                .getEnumByName(color).getName()));
    }

    @Override
    public List<String> getNames() {
        /*
        return repository.findByArticlesGreaterThan().stream()
                .map(User::getName)
                .distinct()
                .collect(Collectors.toList());
         */
        return repository.findAll()
                .stream()
                .filter(u -> u.getArticles().size() > 3)
                .map(User::getName)
                .distinct()
                .collect(Collectors.toList());
    }
}
