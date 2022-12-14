package co.com.poli.bookingsservice.service.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class BookingInDTO {

    @NotEmpty(message = "El titulo no puede estar en blanco")
    private String title;
    @NotEmpty(message = "El director no puede estar en blanco")
    private String director;
    @Min(1)
    @Max(5)
    private int rating;
}
