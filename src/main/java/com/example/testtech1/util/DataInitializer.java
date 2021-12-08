package com.example.testtech1.util;

import com.example.testtech1.model.Article;
import com.example.testtech1.model.Color;
import com.example.testtech1.model.User;
import com.example.testtech1.service.ArticleService;
import com.example.testtech1.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final UserService userService;
    private final ArticleService articleService;

    public DataInitializer(UserService userService,
                           ArticleService articleService) {
        this.userService = userService;
        this.articleService = articleService;
    }

    @PostConstruct
    public void inject() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("User " + random.nextInt(5));
            user.setAge(random.nextInt(50) + i);
            List<Article> articles = new ArrayList<>();
            for (int j = 0; j < random.nextInt(6) + 1; j++) {
                Article article = new Article();
                article.setText("Article " + i + "." + j + random.nextInt(500));
                article.setColor(Color.getRandomColor().getName());
                articles.add(articleService.save(article));
            }
            user.setArticles(articles);
            userService.add(user);
        }
    }
}
