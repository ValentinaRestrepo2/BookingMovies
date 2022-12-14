package co.com.poli.bookingsservice.service;

import co.com.poli.bookingsservice.persistence.entity.Booking;
import co.com.poli.bookingsservice.service.dto.BookingInDTO;

import java.util.List;

public interface BookingService {

    List<Booking> findAll();
    void save(BookingInDTO bookingInDTO);
    Booking findById(Long id);
    void delete(Booking booking);
}