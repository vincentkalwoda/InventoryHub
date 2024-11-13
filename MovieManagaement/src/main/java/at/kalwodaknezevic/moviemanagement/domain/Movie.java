package at.kalwodaknezevic.moviemanagement.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "movies")
public class Movie {
    @EmbeddedId
    private MovieId movieId;
    @Embedded
    private Title title;
    private String description;
    private LocalDate releaseDate;
    private int duration;

    @Embeddable
    public record MovieId(@GeneratedValue @NotNull Long id) {
    }
}
