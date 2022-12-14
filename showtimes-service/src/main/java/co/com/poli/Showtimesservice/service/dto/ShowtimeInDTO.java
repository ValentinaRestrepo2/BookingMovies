package co.com.poli.Showtimesservice.service.dto;

import co.com.poli.Showtimesservice.model.Movie;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
public class ShowtimeInDTO {

    @NotNull(message = "La fecha no puede ser nula")
    private Date date;
    private Collection<Long> movies;
    private List<Movie> listMovies;
}
