package co.com.poli.movieservice;

import co.com.poli.movieservice.mapper.MovieInDTOToMovie;
import co.com.poli.movieservice.persistence.entity.Movie;
import co.com.poli.movieservice.persistence.repository.MovieRepository;
import co.com.poli.movieservice.service.MovieServices;
import co.com.poli.movieservice.service.MovieServicesImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MovieServiceMockTest {

    @Mock
    private MovieRepository movieRepository;
    private MovieServices movieServices;
    private MovieInDTOToMovie movieInDTOToMovie;

    @BeforeEach
    public void begin(){
        MockitoAnnotations.openMocks(this);
        movieServices=new MovieServicesImpl(movieInDTOToMovie,movieRepository);
        Movie movie=Movie.builder()
                .id(1L)
                .title("Los juegos del hambre")
                .director("Gary Ross") //Elimina este falla la prueba
                .rating(3)
                .build();
        Mockito.when(movieRepository.findById(1L)).thenReturn(Optional.of(movie));
    }

    @Test
    public void when_findById_return_movie(){
        Movie movie=movieServices.findById(1L);
        Assertions.assertThat(movie.getTitle()).isEqualTo("Los juegos del hambre");
    }
}
