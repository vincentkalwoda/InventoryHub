package at.kalwodaknezevic.inventoryhub.dtos;

import at.kalwodaknezevic.inventoryhub.domain.Article;
import at.kalwodaknezevic.inventoryhub.domain.Category;

public record ArticleDto(
        String apiKey,
        String name,
        String description,
        Category category,
        Float price,
        Integer quantity) {

    public ArticleDto(Article a) {
        this(
                a.getApiKey().value(),
                a.getName(),
                a.getDescription(),
                a.getCategory(),
                a.getPrice(),
                a.getQuantity());
    }
}