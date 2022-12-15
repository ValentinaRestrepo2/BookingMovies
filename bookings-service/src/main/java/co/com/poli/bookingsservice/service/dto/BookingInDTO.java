package co.com.poli.Bookingsservice.service.dto;

import co.com.poli.Bookingsservice.model.Movie;
import co.com.poli.Bookingsservice.model.Showtime;
import co.com.poli.Bookingsservice.model.User;
import lombok.Data;

import javax.persistence.ElementCollection;
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
}
