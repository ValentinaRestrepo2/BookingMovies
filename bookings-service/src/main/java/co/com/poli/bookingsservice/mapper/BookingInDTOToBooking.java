package co.com.poli.bookingsservice.mapper;

import co.com.poli.bookingsservice.persistence.entity.Booking;
import co.com.poli.bookingsservice.service.dto.BookingInDTO;
import org.springframework.stereotype.Component;

@Component
    public class BookingInDTOToBooking implements IMapper<BookingInDTO, Booking> {
    @Override
    public Booking map(BookingInDTO in) {
        Booking booking = new Booking();
        booking.setUserid(in.getUserid());
        booking.setShowtimeid(in.getShowtimeid());
        booking.setMovies(in.getMovies());
        return booking;
    }
}
