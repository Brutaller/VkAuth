package ru.kpfu.itis.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.kpfu.itis.model.VkAuthUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Юлия on 06.09.2016.
 */
public class VkTokenAuthentication implements Authentication {

    private String name;
    private Object details;
    private VkAuthUser user;
    private boolean authenticated;
    private List<GrantedAuthority> authorities;

    public VkTokenAuthentication(VkAuthUser user, Object details) {
        this.name = user.getUsername();
        this.details = details;
        this.user = user;
        authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        authenticated = true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return user.getAccessToken();
    }

    @Override
    public Object getDetails() {
        return details;
    }

    @Override
    public Object getPrincipal() {
        return user;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        this.authenticated = b;
    }


}
