package ru.kpfu.itis.service;

import org.springframework.security.core.Authentication;

/**
 * Created by Юлия on 06.09.2016.
 */
public interface AuthenticationService {

    boolean login(Authentication authentication);
}
