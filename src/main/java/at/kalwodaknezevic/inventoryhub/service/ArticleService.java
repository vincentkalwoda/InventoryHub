package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.commands.ArticleCommands.CreateArticleCommand;
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

    public Article createArticle(CreateArticleCommand command) {
        ApiKey apiKey;
        do {
            apiKey = new ApiKey("a_" + Base58.random(16));
        } while (articleRepository.findByApiKey(apiKey).isPresent());

        var article = Article.builder()
                .apiKey(apiKey)
                .name(command.name())
                .description(command.description())
                .category(Category.valueOf(command.category()))
                .price(command.price())
                .quantity(command.quantity())
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
