package co.com.poli.Bookingsservice.clientFeign;

import co.com.poli.Bookingsservice.helpers.Response;
import co.com.poli.Bookingsservice.helpers.ResponseBuild;
import co.com.poli.Bookingsservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserClientImplHystrixFallBack implements UserClient{

    private final ResponseBuild build;

    @Override
    public Response findAll() {
        return build.success(new User());
    }

    @Override
    public Response findById(Long id) {
        return build.success(new User());
    }

}
