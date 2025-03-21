package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.commands.ArticleCommands.CreateArticleCommand;
import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import at.kalwodaknezevic.inventoryhub.domain.Article;
import at.kalwodaknezevic.inventoryhub.domain.Category;
import at.kalwodaknezevic.inventoryhub.foundation.Base58;
import at.kalwodaknezevic.inventoryhub.persistance.ArticleRepository;
import at.kalwodaknezevic.inventoryhub.presentation.www.CreateArticleForm;
import at.kalwodaknezevic.inventoryhub.presentation.www.EditArticleForm;
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

    public Article createArticle(CreateArticleForm form) {
        ApiKey apiKey;
        do {
            apiKey = new ApiKey("a_" + Base58.random(16));
        } while (articleRepository.findByApiKey(apiKey).isPresent());

        var article = Article.builder()
                .apiKey(apiKey)
                .name(form.getName())
                .description(form.getDescription())
                .category(form.getCategory())
                .price(form.getPrice())
                .quantity(0)
                .build();
        return articleRepository.save(article);
    }

    public Article updateArticle(Article article) {
        Article articleToUpdate = articleRepository.findByApiKey(article.getApiKey()).get();
        articleToUpdate.setName(article.getName());
        articleToUpdate.setDescription(article.getDescription());
        articleToUpdate.setCategory(article.getCategory());
        articleToUpdate.setPrice(article.getPrice());
        articleToUpdate.setQuantity(article.getQuantity());
        return articleRepository.save(articleToUpdate);
    }

    public Article updateArticle(EditArticleForm form) {
        Article articleToUpdate = articleRepository.findByApiKey(new ApiKey(form.getApiKey().value())).get();
        articleToUpdate.setName(form.getName());
        articleToUpdate.setDescription(form.getDescription());
        articleToUpdate.setCategory(form.getCategory());
        articleToUpdate.setPrice(form.getPrice());
        articleToUpdate.setQuantity(form.getQuantity());
        return articleRepository.save(articleToUpdate);
    }

    public void deleteArticle(String apiKey) {
        Article article = articleRepository.findByApiKey(new ApiKey(apiKey)).get();
        articleRepository.delete(article);
    }

    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticle(String apiKey) {
        return articleRepository.findByApiKey(new ApiKey(apiKey));
    }
}
