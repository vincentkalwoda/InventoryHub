package at.kalwodaknezevic.inventoryhub.dtos;

import at.kalwodaknezevic.inventoryhub.domain.Article;
import at.kalwodaknezevic.inventoryhub.domain.Category;
import at.kalwodaknezevic.inventoryhub.domain.Name;

public record ArticleDto(
        Name name,
        String description,
        Category category,
        Float price,
        Integer quantity) {

    public ArticleDto(Article a) {
        this(a.getName(),
                a.getDescription(),
                a.getCategory(),
                a.getPrice(),
                a.getQuantity());
    }
}