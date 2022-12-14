package co.com.poli.bookingsservice.persistence.entity;
import co.com.poli.bookingsservice.model.Movie;
import co.com.poli.bookingsservice.model.Showtime;
import co.com.poli.bookingsservice.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false,unique = true,nullable = false)
    private Long id;
    @NotNull(message = "El identificador del usuario no puede ser nulo")
    @Column(name = "userid")
    private Long userid;
    @NotNull(message = "El identificador del showtime no puede ser nulo")
    @Column(name = "showtimeid")
    private Long showtimeid;
    @ElementCollection(targetClass = Long.class)
    @Column(name = "movies")
    private Collection<Long> movies;
    @Transient
    private User user;
    @Transient
    private Showtime showtime;
    @Transient
    private List<Movie> listMovies;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return Objects.equals(getId(), booking.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
