package at.kalwodaknezevic.inventoryhub.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "articles")
public class Article {
    @Getter
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