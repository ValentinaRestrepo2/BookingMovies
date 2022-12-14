package co.com.poli.movieservice.service.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class MovieInDTO {

    @NotEmpty(message = "El titulo no puede estar en blanco")
    private String title;
    @NotEmpty(message = "El director no puede estar en blanco")
    private String director;
    @Min(1)
    @Max(5)
    private int rating;
}
