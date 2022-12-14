package co.com.poli.Showtimesservice.mapper;

import co.com.poli.Showtimesservice.persistence.entity.Showtime;
import co.com.poli.Showtimesservice.service.dto.ShowtimeInDTO;
import org.springframework.stereotype.Component;

@Component
    public class ShowtimeInDTOToShowtime implements IMapper<ShowtimeInDTO, Showtime> {
    @Override
    public Showtime map(ShowtimeInDTO in) {
        Showtime movie = new Showtime();
        //movie.setTitle(in.getTitle());
        return movie;
    }
}
