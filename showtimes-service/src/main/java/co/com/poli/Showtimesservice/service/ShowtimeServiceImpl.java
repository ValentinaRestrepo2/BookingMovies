package co.com.poli.Showtimesservice.service;


import co.com.poli.Showtimesservice.mapper.ShowtimeInDTOToShowtime;
import co.com.poli.Showtimesservice.persistence.entity.Showtime;
import co.com.poli.Showtimesservice.persistence.repository.ShowtimeRepository;
import co.com.poli.Showtimesservice.service.dto.ShowtimeInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService {

    private final ShowtimeRepository showtimeRepository;
    private final ShowtimeInDTOToShowtime showtimeInDTOToShowtime;
    @Override
    @Transactional(readOnly = true)
    public List<Showtime> findAll() {
        return showtimeRepository.findAll();
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ShowtimeInDTO showtimeInDTO) {
        Showtime showtime = showtimeInDTOToShowtime.map(showtimeInDTO);
        showtimeRepository.save(showtime);
    }
    @Override
    @Transactional(readOnly = true)
    public Showtime findById(Long id) {
        return showtimeRepository.findById(id).orElse(null);
    }

    @Override
    public void updateById(Showtime showtimeToUpdate, Showtime showtime) {
        showtimeToUpdate.setDate(showtime.getDate());
        showtimeToUpdate.setMovies(showtime.getMovies());
        showtimeRepository.save(showtimeToUpdate);
    }


  }
