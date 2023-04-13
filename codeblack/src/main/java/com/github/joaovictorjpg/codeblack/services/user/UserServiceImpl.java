package com.github.joaovictorjpg.codeblack.services.user;

import com.github.joaovictorjpg.codeblack.model.entity.User;
import com.github.joaovictorjpg.codeblack.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Page<User> getUser(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public User postUser(UserDTO userDTO, String role) {
        User user = (role.equals("STAFF")) ? userDTO.addStaff(userDTO) : userDTO.addCostumer(userDTO);
        return userRepository.save(user);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username).get();
    }
}
