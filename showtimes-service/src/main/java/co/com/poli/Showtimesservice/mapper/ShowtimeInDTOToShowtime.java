package co.com.poli.Showtimesservice.mapper;

import co.com.poli.Showtimesservice.persistence.entity.Showtime;
import co.com.poli.Showtimesservice.service.dto.ShowtimeInDTO;
import org.springframework.stereotype.Component;

@Component
    public class ShowtimeInDTOToShowtime implements IMapper<ShowtimeInDTO, Showtime> {
    @Override
    public Showtime map(ShowtimeInDTO in) {
        Showtime showtime = new Showtime();
        showtime.setDate(in.getDate());
        showtime.setMovies(in.getMovies());
        showtime.setListMovies(in.getListMovies());
        return showtime;
    }
}
