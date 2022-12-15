package co.com.poli.Bookingsservice.clientFeign;

import co.com.poli.Bookingsservice.helpers.Response;
import co.com.poli.Bookingsservice.helpers.ResponseBuild;
import co.com.poli.Bookingsservice.model.Showtime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShowtimeClientImplHystrixFallBack implements ShowtimeClient {

    private final ResponseBuild build;

    @Override
    public Response findAll() {
        return build.success(new Showtime());
    }

    @Override
    public Response findById(Long id) {
        return build.success(new Showtime());
    }

}
