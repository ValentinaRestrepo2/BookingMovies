package co.com.poli.Showtimesservice.persistence.repository;

import co.com.poli.Showtimesservice.persistence.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime,Long> {

}