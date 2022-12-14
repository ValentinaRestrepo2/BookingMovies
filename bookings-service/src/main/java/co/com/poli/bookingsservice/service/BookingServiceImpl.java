package co.com.poli.bookingsservice.service;


import co.com.poli.bookingsservice.clientFeign.MovieClient;
import co.com.poli.bookingsservice.clientFeign.ShowtimeClient;
import co.com.poli.bookingsservice.clientFeign.UserClient;
import co.com.poli.bookingsservice.mapper.BookingInDTOToBooking;
import co.com.poli.bookingsservice.model.Movie;
import co.com.poli.bookingsservice.model.Showtime;
import co.com.poli.bookingsservice.model.User;
import co.com.poli.bookingsservice.persistence.entity.Booking;
import co.com.poli.bookingsservice.persistence.repository.BookingRepository;
import co.com.poli.bookingsservice.service.dto.BookingInDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingInDTOToBooking bookingInDTOToBooking;
    private final UserClient userClient;

    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(BookingInDTO bookingInDTO) {

        Booking booking = bookingInDTOToBooking.map(bookingInDTO);
        bookingRepository.save(booking);
    }

    @Override
    @Transactional(readOnly = true)
    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Booking booking) {
        bookingRepository.delete(booking);
    }

}
