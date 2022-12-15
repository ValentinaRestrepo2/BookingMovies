package co.com.poli.Bookingsservice.mapper;

import co.com.poli.Bookingsservice.persistence.entity.Booking;
import co.com.poli.Bookingsservice.service.dto.BookingInDTO;
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
