package at.kalwodaknezevic.inventoryhub.presentation.www;

import at.kalwodaknezevic.inventoryhub.domain.Article.ArticleId;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemForm {
    @NotNull
    private ArticleId articleId;

    @Min(1)
    @NotNull
    private Integer quantity;
}