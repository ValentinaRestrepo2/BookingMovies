package co.com.poli.bookingsservice.service.dto;

import co.com.poli.bookingsservice.model.Movie;
import co.com.poli.bookingsservice.model.Showtime;
import co.com.poli.bookingsservice.model.User;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

@Data
public class BookingInDTO {

    @NotNull(message = "El identificador del usuario no puede ser nulo")
    private Long userid;
    @NotNull(message = "El identificador del showtime no puede ser nulo")
    private Long showtimeid;
    @ElementCollection(targetClass = Long.class)
    private Collection<Long> movies;
    private User user;
    private Showtime showtime;
    private List<Movie> listMovies;
}
