package com.github.joaovictor.jpg.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    public AuthenticationResponse register(RegisterRequest request) {
        return null;
    }

    public AuthenticationResponse authenticate(AuhenticationRequest request) {
        return null;
    }
}
