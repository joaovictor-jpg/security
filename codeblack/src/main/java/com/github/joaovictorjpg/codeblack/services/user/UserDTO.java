package com.github.joaovictorjpg.codeblack.services.user;

import com.github.joaovictorjpg.codeblack.model.Enum.RoleEnum;
import com.github.joaovictorjpg.codeblack.model.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record UserDTO(
        @NotNull @NotEmpty @Email String email,
        @NotNull @NotEmpty @Length(min = 5, max = 15) String username,
        @NotNull @NotEmpty String password
        ) {

    public User addCostumer(UserDTO userDTO) {
        return new User(
                null,
                null,
                this.username,
                null,
                LocalDateTime.now(),
                LocalDateTime.now(),
                RoleEnum.COSTUMER
        );
    }

    public User addStaff(UserDTO userDTO) {
        return new User(
                null,
                this.email,
                this.username,
                this.password,
                LocalDateTime.now(),
                LocalDateTime.now(),
                RoleEnum.STAFF
        );
    }

}
