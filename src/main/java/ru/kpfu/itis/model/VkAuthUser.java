package ru.kpfu.itis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Юлия on 31.08.2016.
 */

@Entity
@Table(name = "vk_auth_user")
public class VkAuthUser extends AuthUser {

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "photo")
    private String photo;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
