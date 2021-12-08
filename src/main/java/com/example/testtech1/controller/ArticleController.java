package com.example.testtech1.controller;

import com.example.testtech1.dto.response.ArticleResponseDto;
import com.example.testtech1.model.Article;
import com.example.testtech1.service.ArticleService;
import com.example.testtech1.service.mapper.ArticleMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
@Api(value = "Article Controller", description = "Available end-point for Articles")
public class ArticleController {
    private final ArticleService articleService;
    private final ArticleMapper articleMapper;

    public ArticleController(ArticleService articleService, ArticleMapper articleMapper) {
        this.articleService = articleService;
        this.articleMapper = articleMapper;
    }

    @ApiOperation(value = "Add new article")
    @PostMapping
    public ArticleResponseDto add(@RequestBody Article article) {
        return articleMapper.mapToDto(articleService.save(article));
    }
}
