package co.com.poli.Showtimesservice.clientFeign;

import co.com.poli.Showtimesservice.helpers.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="movies-service", fallback = MovieClientImplHystrixFallBack.class)
public interface MovieClient {

    @GetMapping("/bookmovies/api/v1/movies")
    Response findAll();

    @GetMapping("/bookmovies/api/v1/movies/{id}")
    Response findById(@PathVariable("id") Long id);
}