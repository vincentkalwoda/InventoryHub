package at.kalwodaknezevic.inventoryhub.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "articles")
public class Article {
    @EmbeddedId
    private ArticleId articleId;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "apiKey"))
    private ApiKey apiKey;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private Category category;

    @NotNull
    private Float price;

    private Integer quantity;

    @Embeddable
    public record ArticleId(@GeneratedValue @NotNull Long id) {
    }
}