package ru.kpfu.itis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Юлия on 31.08.2016.
 */

@Entity
@Table(name = "simple_auth_user")
public class SimpleAuthUser extends AuthUser {

    @Column(name = "password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
