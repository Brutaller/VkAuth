package ru.kpfu.itis.utils;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.itis.form.UserRegistrationForm;
import ru.kpfu.itis.model.SimpleAuthUser;
import ru.kpfu.itis.model.enums.AuthorityType;

public class UserRegistrationFormToUserTransformer {

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static SimpleAuthUser transform(UserRegistrationForm form) {
        if (form == null) {
            return null;
        }
        SimpleAuthUser user = new SimpleAuthUser();
        user.setUsername(form.getUsername());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setPassword(encoder.encode(form.getPassword()));
        user.setType(AuthorityType.SIMPLE);
        return user;
    }
}
