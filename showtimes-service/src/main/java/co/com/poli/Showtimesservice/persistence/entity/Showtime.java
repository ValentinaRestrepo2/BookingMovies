package co.com.poli.Showtimesservice.persistence.entity;

import co.com.poli.Showtimesservice.model.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "showtimes")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false,unique = true,nullable = false)
    private Long id;
    @NotNull(message = "La fecha no puede ser nula")
    @Column(name = "date")
    private Date date;
    @ElementCollection(targetClass = Long.class)
    @Column(name = "movies")
    private Collection<Long> movies;

    @Transient
    private List<Movie> listMovies;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Showtime)) return false;
        Showtime showtime = (Showtime) o;
        return getId().equals(showtime.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
