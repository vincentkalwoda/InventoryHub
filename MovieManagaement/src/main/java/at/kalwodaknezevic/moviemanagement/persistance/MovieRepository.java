package at.kalwodaknezevic.moviemanagement.persistance;

import at.kalwodaknezevic.moviemanagement.domain.Movie;
import at.kalwodaknezevic.moviemanagement.domain.Title;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Movie.MovieId> {

    Optional<Movie> findByTitle(Title title);
}
