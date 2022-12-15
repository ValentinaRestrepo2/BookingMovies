package co.com.poli.Bookingsservice.clientFeign;
import co.com.poli.Bookingsservice.helpers.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "showtimes-service", fallback = ShowtimeClientImplHystrixFallBack.class)
public interface ShowtimeClient {

    @GetMapping("/bookmovies/api/v1/showtimes")
    Response findAll();

    @GetMapping("/bookmovies/api/v1/showtimes/{id}")
    Response findById(@PathVariable("id") Long id);
}
