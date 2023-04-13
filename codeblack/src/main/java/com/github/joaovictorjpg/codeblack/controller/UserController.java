package com.github.joaovictorjpg.codeblack.controller;

import com.github.joaovictorjpg.codeblack.model.entity.User;
import com.github.joaovictorjpg.codeblack.services.user.UserDTO;
import com.github.joaovictorjpg.codeblack.services.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/users")
    public ResponseEntity<Page<User>> getUser(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok().body(userService.getUser(page, size));
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<User> show(@PathVariable String username) {
        return ResponseEntity.ok().body(userService.getUser(username));
    }

    @PostMapping("/users/post/{role}")
    public ResponseEntity<User> postUser(@RequestBody UserDTO userDTO, @PathVariable String role) {
        User user = userService.postUser(userDTO, role);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(uri).body(user);

    }

}
