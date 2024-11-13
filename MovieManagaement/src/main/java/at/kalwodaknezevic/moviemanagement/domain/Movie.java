package at.kalwodaknezevic.moviemanagement.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
public class Movie extends AbstractPersistable<Long> {
    @Embedded
    private Title title;
    private String description;
    private LocalDate releaseDate;
    private int duration;
}
