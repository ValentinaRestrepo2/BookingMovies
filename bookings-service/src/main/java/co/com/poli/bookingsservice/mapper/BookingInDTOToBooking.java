package co.com.poli.bookingsservice.mapper;

import co.com.poli.bookingsservice.persistence.entity.Booking;
import co.com.poli.bookingsservice.service.dto.BookingInDTO;
import org.springframework.stereotype.Component;

@Component
    public class BookingInDTOToBooking implements IMapper<BookingInDTO, Booking> {
    @Override
    public Booking map(BookingInDTO in) {
        Booking movie = new Booking();
        //movie.setTitle(in.getTitle());
        return movie;
    }
}
