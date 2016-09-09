package ru.kpfu.itis.model.enums;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Юлия on 06.09.2016.
 */
public enum Authority implements GrantedAuthority {

    ROLE_USER;

    @Override
    public String getAuthority() {
        return toString();
    }
}
