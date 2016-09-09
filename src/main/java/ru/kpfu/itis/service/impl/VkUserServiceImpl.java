package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.aspect.WriteConnection;
import ru.kpfu.itis.model.VkAuthUser;
import ru.kpfu.itis.model.enums.AuthorityType;
import ru.kpfu.itis.repository.VkAuthUserRepository;
import ru.kpfu.itis.service.VkUserService;

/**
 * Created by Юлия on 07.09.2016.
 */
@Service
public class VkUserServiceImpl implements VkUserService {

    @Autowired
    VkAuthUserRepository vkRepository;

    @Override
    @WriteConnection
    public void saveNewUser(String accessToken, String uid, String firstName, String lastName, String photo) {
        VkAuthUser user = new VkAuthUser();
        user.setAccessToken(accessToken);
        user.setUsername(uid);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setType(AuthorityType.VK);
        user.setPhoto(photo);
        vkRepository.save(user);
    }

    @Override
    @WriteConnection
    public void updateUserInfo(String id, String accessToken, String firstName, String lastName, String photo) {
        vkRepository.updateUserInfoById(id, accessToken, firstName,lastName, photo);
    }
}
