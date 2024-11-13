package at.kalwodaknezevic.moviemanagement.persistance;

import at.kalwodaknezevic.moviemanagement.domain.Movie;
import at.kalwodaknezevic.moviemanagement.domain.Title;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MovieRepositoryTest {
    private @Autowired MovieRepository movieRepository;
    private Title title;
    private Movie movie;

    @BeforeEach
    void setup() {
        title = new Title("The Matrix");
        movie = Movie.builder().title(title).description("A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.").releaseDate(java.time.LocalDate.of(1999, 3, 31)).duration(136).build();
    }

    @Test
    void can_save() {
        // expect
        assertThat(movieRepository.saveAndFlush(movie).getMovieId()).isNotNull();
    }

    @Test
    void can_find_by_title() {
        // arrange / given
        movieRepository.saveAndFlush(movie);

        // act / when
        var foundMovie = movieRepository.findByTitle(title);

        // assert / then
        assertThat(foundMovie).isNotEmpty();
        assertThat(foundMovie.get().getTitle()).isEqualTo(title);
    }
}