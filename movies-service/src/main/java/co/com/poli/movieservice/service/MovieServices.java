package co.com.poli.movieservice.service;

import co.com.poli.movieservice.persistence.entity.Movie;
import co.com.poli.movieservice.service.dto.MovieInDTO;

import java.util.List;

public interface MovieServices {
    List<Movie> findAll();
    void save(MovieInDTO movieInDTO);
    Movie findById(Long id);
    void delete(Movie movie);


}
