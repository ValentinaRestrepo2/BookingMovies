package co.com.poli.bookingsservice.service;


import co.com.poli.bookingsservice.clientFeign.UserClient;
import co.com.poli.bookingsservice.model.User;
import co.com.poli.bookingsservice.persistence.entity.Booking;
import co.com.poli.bookingsservice.persistence.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserClient userClient;

    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Booking booking) {
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

    @Override
    @Transactional(readOnly = true)
    public Booking findByUserID(Long userId) {
        Booking booking=bookingRepository.findByUserID(userId);
        ModelMapper modelMapper=new ModelMapper();
        User user= modelMapper.map(userClient.findById(booking.getUserid()).getData(),User.class);
        return booking;
    }
}
