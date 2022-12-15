package co.com.poli.Bookingsservice.service;

import co.com.poli.Bookingsservice.clientFeign.UserClient;
import co.com.poli.Bookingsservice.mapper.BookingInDTOToBooking;
import co.com.poli.Bookingsservice.persistence.entity.Booking;
import co.com.poli.Bookingsservice.persistence.repository.BookingRepository;
import co.com.poli.Bookingsservice.service.dto.BookingInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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