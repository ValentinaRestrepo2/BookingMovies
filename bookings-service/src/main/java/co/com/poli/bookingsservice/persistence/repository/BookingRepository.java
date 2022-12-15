package co.com.poli.Bookingsservice.persistence.repository;

import co.com.poli.Bookingsservice.persistence.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
}