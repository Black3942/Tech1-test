package com.example.testtech1.service.mapper;

import com.example.testtech1.dto.request.ArticleRequestDto;
import com.example.testtech1.dto.response.ArticleResponseDto;
import com.example.testtech1.model.Article;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {
    public ArticleResponseDto mapToDto(Article article) {
        ArticleResponseDto responseDto = new ArticleResponseDto();
        responseDto.setId(article.getId());
        responseDto.setText(article.getText());
        responseDto.setColor(article.getColor());
        return responseDto;
    }

    public Article mapToModel(ArticleRequestDto dto) {
        Article article = new Article();
        article.setId(dto.getId());
        article.setText(dto.getText());
        article.setColor(dto.getColor());
        return article;
    }
}
