package co.com.poli.movieservice.service;

import co.com.poli.movieservice.mapper.MovieInDTOToMovie;
import co.com.poli.movieservice.persistence.entity.Movie;
import co.com.poli.movieservice.persistence.repository.MovieRepository;
import co.com.poli.movieservice.service.dto.MovieInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServicesImpl implements MovieServices {

    private final MovieInDTOToMovie movieInDTOToMovie;
    private final MovieRepository movieRepository;
    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(MovieInDTO movieInDTO) {
        Movie movie = movieInDTOToMovie.map(movieInDTO);
        movieRepository.save(movie);
    }
    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }





}
