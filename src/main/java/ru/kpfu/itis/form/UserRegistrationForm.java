package ru.kpfu.itis.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Юлия on 05.09.2016.
 */
public class UserRegistrationForm {

    @NotEmpty(message = "Логин не может быть пустым")
    private String username;

    @NotEmpty(message = "Имя не может быть пустым")
    private String firstName;

    @NotEmpty(message = "Фамилия не может быть пустым")
    private String LastName;

    @Size(min = 4, max = 24, message = "Пароль неверной длины")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
