package co.com.poli.Showtimesservice.service;


import co.com.poli.Showtimesservice.clientFeign.MovieClient;
import co.com.poli.Showtimesservice.mapper.ShowtimeInDTOToShowtime;
import co.com.poli.Showtimesservice.model.Movie;
import co.com.poli.Showtimesservice.persistence.entity.Showtime;
import co.com.poli.Showtimesservice.persistence.repository.ShowtimeRepository;
import co.com.poli.Showtimesservice.service.dto.ShowtimeInDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService {

    private final ShowtimeRepository showtimeRepository;
    private final ShowtimeInDTOToShowtime showtimeInDTOToShowtime;
    private final MovieClient movieClient;

    @Override
    @Transactional(readOnly = true)
    public List<Showtime> findAll() {
        List<Showtime> showtimeList = showtimeRepository.findAll();
        for (Showtime showtime: showtimeList) {
            ObtenerMovies(showtime);
        }
        return showtimeList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ShowtimeInDTO showtimeInDTO) {
        Showtime showtime = showtimeInDTOToShowtime.map(showtimeInDTO);
        showtimeRepository.save(showtime);
    }

    @Override
    @Transactional(readOnly = true)
    public Showtime findById(Long id) {
        Showtime showtime = showtimeRepository.findById(Long.valueOf(id)).orElse(null);
        if(showtime == null || showtime.getMovies() == null || showtime.getMovies().isEmpty()){
            return showtime;
        }
        ObtenerMovies(showtime);
        return showtime;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(Showtime showtimeToUpdate, Showtime showtime) {
        showtimeToUpdate.setDate(showtime.getDate());
        showtimeToUpdate.setMovies(showtime.getMovies());
        showtimeRepository.save(showtimeToUpdate);
    }

    private void ObtenerMovies(Showtime showtime) {
        List<Movie> movies = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Long movieId : showtime.getMovies()) {
            Movie movie = modelMapper.map(movieClient.findById(movieId).getData(), Movie.class);
            movies.add(movie);
        }
        showtime.setListMovies(movies);
    }

  }
