package co.com.poli.Bookingsservice.service;

import co.com.poli.Bookingsservice.persistence.entity.Booking;
import co.com.poli.Bookingsservice.service.dto.BookingInDTO;

import java.util.List;

public interface BookingService {

    List<Booking> findAll();
    void save(BookingInDTO bookingInDTO);
    Booking findById(Long id);
    void delete(Long id);
    List<Booking> ObtenerReservaUser(Long userid);

}