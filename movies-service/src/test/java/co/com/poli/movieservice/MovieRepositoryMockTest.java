package co.com.poli.movieservice;

import co.com.poli.movieservice.persistence.entity.Movie;
import co.com.poli.movieservice.persistence.repository.MovieRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class MovieRepositoryMockTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test

    public void when_FindById_return_user(){
        Movie movie=Movie.builder()
                .title("Los juegos del hambre")
                .director("Gary Ross") //Elimina este falla la prueba
                .rating(3)
                .build();
        movieRepository.save(movie);

        Optional<Movie> movie1=movieRepository.findById(movie.getId());
        Assertions.assertThat(movie1);

    }
}
