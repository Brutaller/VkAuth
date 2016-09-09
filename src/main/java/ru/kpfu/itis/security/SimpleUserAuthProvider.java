package ru.kpfu.itis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.itis.model.SimpleAuthUser;
import ru.kpfu.itis.model.enums.AuthorityType;
import ru.kpfu.itis.repository.SimpleAuthUserRepository;

import java.util.ArrayList;
import java.util.List;

public class SimpleUserAuthProvider implements AuthenticationProvider {

    @Autowired
    SimpleAuthUserRepository userRepository;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();

        SimpleAuthUser user = userRepository.findOneByUsernameAndType(login, AuthorityType.SIMPLE);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }

        String password = authentication.getCredentials().toString();

        if (!encoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("invalid password");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new UsernamePasswordAuthenticationToken(user, null, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
