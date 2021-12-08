package com.example.testtech1.service.impl;

import com.example.testtech1.model.Article;
import com.example.testtech1.repository.ArticleRepository;
import com.example.testtech1.service.ArticleService;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository repository;

    public ArticleServiceImpl(ArticleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Article save(Article article) {
        return repository.save(article);
    }
}
