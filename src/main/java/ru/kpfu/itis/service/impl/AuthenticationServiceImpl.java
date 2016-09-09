package ru.kpfu.itis.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.service.AuthenticationService;

import javax.annotation.Resource;

/**
 * Created by Юлия on 06.09.2016.
 */

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Resource(name = "authenticationManager")
    private AuthenticationManager authenticationManager;

    public boolean login(Authentication authentication) {
        try {
            Authentication authenticate = authenticationManager.authenticate(authentication);
            if (authenticate.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(authenticate);
                return true;
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return false;
    }
}
