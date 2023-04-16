package com.github.joaovictorjpg.codeblack.auth;

import com.github.joaovictorjpg.codeblack.services.user.UserDTO;
import com.github.joaovictorjpg.codeblack.utils.GeneralUtilies;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register/{role}")
    public ResponseEntity<Response> register(@RequestBody UserDTO userDTO, @PathVariable String role) {
        URI uri = GeneralUtilies.toUri("/register/{role}");
        return ResponseEntity.created(uri).body(authService.registre(userDTO, role));
    }

    @PostMapping("/login")
    public ResponseEntity<Response> register(@RequestBody AuthDTO authDTO) {
        return ResponseEntity.ok().body(authService.login(authDTO));
    }

}
