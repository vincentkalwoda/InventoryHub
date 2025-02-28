package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import at.kalwodaknezevic.inventoryhub.domain.Article;
import at.kalwodaknezevic.inventoryhub.domain.Category;
import at.kalwodaknezevic.inventoryhub.foundation.Base58;
import at.kalwodaknezevic.inventoryhub.persistance.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public Article createArticle(String name, String description, Category category, Float price, Integer quantity) {
        ApiKey apiKey;
        do {
            apiKey = new ApiKey("a_" + Base58.random(10));
        } while (articleRepository.findByApiKey(apiKey).isPresent());

        var article = Article.builder()
                .apiKey(apiKey)
                .name(name)
                .description(description)
                .category(category)
                .price(price)
                .quantity(quantity)
                .build();
        return articleRepository.save(article);
    }

    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticle(Long articleId) {
        return articleRepository.findById(new Article.ArticleId(articleId));
    }
}
