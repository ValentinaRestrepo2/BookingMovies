package co.com.poli.userservice.service.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserInDTO {

    @NotEmpty(message = "El nombre no puede estar en blanco")
    private String name;
    @NotEmpty(message = "El apellido no puede estar en blanco")
    private String lastname;
}
