package co.com.poli.Showtimesservice.clientFeign;

import co.com.poli.Showtimesservice.helpers.Response;
import co.com.poli.Showtimesservice.helpers.ResponseBuild;
import co.com.poli.Showtimesservice.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieClientImplHystrixFallBack implements MovieClient{

    private final ResponseBuild build;

    @Override
    public Response findAll() {
        return build.success(new Movie());
    }

    @Override
    public Response findById(Long id) {
        return build.success(new Movie());
    }
}
