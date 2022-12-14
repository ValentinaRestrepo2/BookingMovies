package co.com.poli.bookingsservice.persistence.repository;

import co.com.poli.bookingsservice.persistence.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    Booking findByUserID(Long userId);
}