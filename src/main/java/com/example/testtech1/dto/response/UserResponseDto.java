package com.example.testtech1.dto.response;

import com.example.testtech1.model.Article;
import lombok.Data;
import java.util.List;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private int age;
    private List<Article> articles;
}
