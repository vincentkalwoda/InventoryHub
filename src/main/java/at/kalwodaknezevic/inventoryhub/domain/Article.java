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
    private Name name;
    private String description;
    private Category category;
    private Float price;

    @Embeddable
    public record ArticleId(@GeneratedValue @NotNull Long id) {
    }
}