package com.github.joaovictor.jpg.security.auth;

import com.github.joaovictor.jpg.security.entity.User;
import com.github.joaovictor.jpg.security.entity.role.Role;
import com.github.joaovictor.jpg.security.repository.UserRepository;
import com.github.joaovictor.jpg.security.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;

    private final JwtService jwtService;

    public AuthenticationResponse register(RegisterRequest request) {
        User user = User
                .builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        String token = jwtService.genereteToken(user);
        return AuthenticationResponse
                .builder()
                .token(token)
                .build();
    }

    public AuthenticationResponse authenticate(AuhenticationRequest request) {
        return null;
    }
}
