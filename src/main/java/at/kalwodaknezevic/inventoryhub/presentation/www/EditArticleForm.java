package at.kalwodaknezevic.inventoryhub.presentation.www;

import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import at.kalwodaknezevic.inventoryhub.domain.Article;
import at.kalwodaknezevic.inventoryhub.domain.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EditArticleForm {

    @NotNull
    private ApiKey apiKey;

    @NotBlank
    @NotNull
    private String name;

    private String description;

    @NotNull
    private Category category;

    @NotNull
    private float price;

    @NotNull
    private int quantity;

    public EditArticleForm(Article article) {
        this.apiKey = article.getApiKey();
        this.name = article.getName();
        this.description = article.getDescription();
        this.category = article.getCategory();
        this.price = article.getPrice();
        this.quantity = article.getQuantity();
    }
}