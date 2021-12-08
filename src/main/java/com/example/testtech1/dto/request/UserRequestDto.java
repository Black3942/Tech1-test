package com.example.testtech1.dto.request;

import com.example.testtech1.model.Article;
import java.util.List;
import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private int age;
    private List<Article> articles;
}
