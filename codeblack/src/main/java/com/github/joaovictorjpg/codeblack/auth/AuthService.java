package com.github.joaovictorjpg.codeblack.auth;

import com.github.joaovictorjpg.codeblack.config.JwtService;
import com.github.joaovictorjpg.codeblack.model.entity.User;
import com.github.joaovictorjpg.codeblack.repository.UserRepository;
import com.github.joaovictorjpg.codeblack.services.user.UserDTO;
import com.github.joaovictorjpg.codeblack.services.user.UserService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsService userDetailsService;

    public Response registre(UserDTO userDTO, String role) {
        User user = userService.postUser(userDTO,role);
        String jwt = jwtService.generateToken(user);
        return Response
                .builder()
                .token(jwt)
                .build();
    }

    public Response login(AuthDTO authDTO) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authDTO.login(), authDTO.password())
        );

        var user = this.userDetailsService.loadUserByUsername(authDTO.login());

        String jwt = jwtService.generateToken(user);
        return Response
                .builder()
                .token(jwt)
                .build();
    }


}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Response {
    private String token;
}
