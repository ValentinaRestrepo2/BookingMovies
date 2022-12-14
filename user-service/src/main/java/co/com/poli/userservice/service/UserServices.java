package co.com.poli.userservice.service;

import co.com.poli.userservice.persistence.entity.User;
import co.com.poli.userservice.service.dto.UserInDTO;

import java.util.List;

public interface UserServices {
    List<User> findAll();
    User findById(Long id);
    void save(UserInDTO userInDTO);
    void delete(User user);


}
