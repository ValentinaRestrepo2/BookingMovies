package co.com.poli.bookingsservice.clientFeign;

import co.com.poli.bookingsservice.helpers.Response;
import co.com.poli.bookingsservice.helpers.ResponseBuild;
import co.com.poli.bookingsservice.model.Movie;
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
