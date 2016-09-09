package ru.kpfu.itis.service;

/**
 * Created by Юлия on 07.09.2016.
 */
public interface VkUserService {

    void saveNewUser(String accessToken, String uid, String firstName, String lastName, String photo);

    void updateUserInfo(String id, String accessToken, String firstName, String lastName, String photo);

}
