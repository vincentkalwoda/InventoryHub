package at.kalwodaknezevic.inventoryhub.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@Builder

@Entity
@Table(name = "articles")
public class Article {
    @Getter
    @EmbeddedId
    private ArticleId articleId;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "name"))
    })
    @NotNull
    private Name name;
    private String description;
    @NotNull
    private Category category;
    @NotNull
    private Float price;
    private Integer quantity;

    @Embeddable
    public record ArticleId(@GeneratedValue @NotNull Long id) {
    }

    @Builder
    public Article(ArticleId articleId, Name name, String description, Category category, Float price, Integer quantity) {
        this.articleId = articleId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }
}