package com.github.joaovictorjpg.codeblack.services.user;

import com.github.joaovictorjpg.codeblack.model.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<User> getUser(int page, int size);
    User postUser(UserDTO userDTO, String role);
    User getUser(String username);
}
