package co.com.poli.Bookingsservice.service;

import co.com.poli.Bookingsservice.clientFeign.MovieClient;
import co.com.poli.Bookingsservice.clientFeign.ShowtimeClient;
import co.com.poli.Bookingsservice.clientFeign.UserClient;
import co.com.poli.Bookingsservice.mapper.BookingInDTOToBooking;
import co.com.poli.Bookingsservice.model.Movie;
import co.com.poli.Bookingsservice.model.Showtime;
import co.com.poli.Bookingsservice.model.User;
import co.com.poli.Bookingsservice.persistence.entity.Booking;
import co.com.poli.Bookingsservice.persistence.repository.BookingRepository;
import co.com.poli.Bookingsservice.service.dto.BookingInDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingInDTOToBooking bookingInDTOToBooking;
    private final UserClient userClient;
    private final MovieClient movieClient;
    private final ShowtimeClient showtimeClient;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(BookingInDTO bookingInDTO) {
        Booking booking = bookingInDTOToBooking.map(bookingInDTO);
        bookingRepository.save(booking);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }
    @Override
    @Transactional(readOnly = true)
    public Booking findById(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if(booking == null){
            return booking;
        }
        ObtenerUser(booking);
        ObtenerShow(booking);
        ObtenerMovie(booking);
        return booking;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Booking> ObtenerReservaUser(Long userid) {
        List<Booking> list = bookingRepository.findAll().stream().
                filter(booking -> Objects.equals(booking.getUserid(), Long.valueOf(userid))).toList();
        for (Booking booking : list) {
            ObtenerUser(booking);
            ObtenerShow(booking);
            if (booking.getMovies() != null && !booking.getMovies().isEmpty()) {
                ObtenerMovie(booking);
            }
        }
        return list;
    }
     @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
         bookingRepository.deleteById(id);
    }

    private void ObtenerUser(Booking booking) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userClient.findById(booking.getUserid()).getData(), User.class);
        booking.setUser(user);
    }
    private void ObtenerMovie(Booking booking) {
        List<Movie> movies = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Long movieId : booking.getMovies()) {
            Movie movie = modelMapper.map(movieClient.findById(movieId).getData(), Movie.class);
            movies.add(movie);
        }
        booking.setListMovies(movies);
    }

    private void ObtenerShow(Booking booking) {
        ModelMapper modelMapper = new ModelMapper();
        Showtime showtime = modelMapper.map(showtimeClient.findById(booking.getShowtimeid()).getData(), Showtime.class);
        booking.setShowtime(showtime);

    }
}