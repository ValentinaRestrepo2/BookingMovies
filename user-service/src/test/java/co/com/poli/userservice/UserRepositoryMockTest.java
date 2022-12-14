package co.com.poli.userservice;

import co.com.poli.userservice.persistence.entity.User;
import co.com.poli.userservice.persistence.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class UserRepositoryMockTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void when_findByCategory_return_ListProduct() {
        User user = User.builder()
                .name("Test")
                .lastname("Prueba")
                .build();
        userRepository.save(user);
        List<User> products = userRepository.findAll();
        Assertions.assertThat(products.size()).isEqualTo(1);
    }
}
