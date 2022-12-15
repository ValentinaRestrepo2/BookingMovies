package co.com.poli.userservice;

import co.com.poli.userservice.persistence.entity.User;
import co.com.poli.userservice.persistence.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class UserRepositoryMockTest  {

    @Autowired
    private UserRepository userRepository;

    @Test

    public void when_FindById_return_user(){
        User user=User.builder()
                .name("Juan")
                .lastname("Alvarez") //Elimina este falla la prueba
                .build();
        userRepository.save(user);

        Optional<User> user1=userRepository.findById(user.getId());
        Assertions.assertThat(user);

    }
}
