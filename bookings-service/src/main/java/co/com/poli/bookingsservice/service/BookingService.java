package co.com.poli.bookingsservice.service;

import co.com.poli.bookingsservice.persistence.entity.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> findAll();
    void save(Booking booking);
    Booking findById(Long id);
    void delete(Booking booking);
    Booking findByUserID(Long userId);
}