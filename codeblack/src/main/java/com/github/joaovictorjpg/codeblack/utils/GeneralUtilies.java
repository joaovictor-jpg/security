package com.github.joaovictorjpg.codeblack.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class GeneralUtilies {

    public static URI toUri(String path) {
        return URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path(path)
                .toString());
    }

    public static String encide(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

}
