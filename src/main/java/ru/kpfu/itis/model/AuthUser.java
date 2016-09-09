package ru.kpfu.itis.model;

import org.hibernate.annotations.GenericGenerator;
import ru.kpfu.itis.model.enums.AuthorityType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Юлия on 31.08.2016.
 */
@Entity
@Table(name = "auth_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class AuthUser implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",
            strategy = "uuid")
    @Column(name = "id")
    private String id;

    //для вк это id, для обычной - логин
    @Column(name = "username", length = 64, nullable = false)
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private AuthorityType type;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AuthorityType getType() {
        return type;
    }

    public void setType(AuthorityType type) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
