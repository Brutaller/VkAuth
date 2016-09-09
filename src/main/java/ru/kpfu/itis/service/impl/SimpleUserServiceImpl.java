package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.aspect.WriteConnection;
import ru.kpfu.itis.form.UserRegistrationForm;
import ru.kpfu.itis.model.SimpleAuthUser;
import ru.kpfu.itis.repository.SimpleAuthUserRepository;
import ru.kpfu.itis.service.SimpleUserService;
import ru.kpfu.itis.utils.UserRegistrationFormToUserTransformer;

/**
 * Created by Юлия on 05.09.2016.
 */

@Service
public class SimpleUserServiceImpl implements SimpleUserService {

    @Autowired
    SimpleAuthUserRepository userRepository;

    @Override
    @WriteConnection
    public void saveNewUser(UserRegistrationForm form) {
        SimpleAuthUser user = UserRegistrationFormToUserTransformer.transform(form);
        userRepository.save(user);
    }

}
