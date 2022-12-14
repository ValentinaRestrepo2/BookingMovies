package co.com.poli.Showtimesservice.service;

import co.com.poli.Showtimesservice.persistence.entity.Showtime;

import java.util.List;

public interface ShowtimeService {

    List<Showtime> findAll();
    void save(Showtime showtime);
    Showtime findById(Long id);
    void updateById(Showtime showtimeToUpdate, Showtime showtime);

}