package co.com.poli.userservice;

import co.com.poli.userservice.mapper.UserInDTOToUser;
import co.com.poli.userservice.persistence.entity.User;
import co.com.poli.userservice.persistence.repository.UserRepository;
import co.com.poli.userservice.service.UserServices;
import co.com.poli.userservice.service.UserServicesImpl;
import com.google.inject.spi.PrivateElements;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserServiceMockTest {

    @Mock
    private UserRepository userRepository;
    private UserServices userServices;
    private UserInDTOToUser userInDTOToUser;

    @BeforeEach
    public void begin(){
        MockitoAnnotations.openMocks(this);
        userServices=new UserServicesImpl(userRepository, userInDTOToUser);
        User user=User.builder()
                .id(5L)
                .name("Juan")
                .lastname("Alvarez") //Elimina este falla la prueba
                .build();
        Mockito.when(userRepository.findById(5L)).thenReturn(Optional.of(user));
    }

    @Test
    public void when_findById_return_user(){
        User user=userServices.findById(5L);
        Assertions.assertThat(user.getName()).isEqualTo("Juan");
    }
}
