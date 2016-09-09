package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.aspect.ReadOnlyConnection;
import ru.kpfu.itis.model.SimpleAuthUser;
import ru.kpfu.itis.model.enums.AuthorityType;

/**
 * Created by Юлия on 05.09.2016.
 */

@Repository
public interface SimpleAuthUserRepository extends JpaRepository<SimpleAuthUser, String> {

    @ReadOnlyConnection
    SimpleAuthUser findOneByUsernameAndType(String identificationName, AuthorityType type);
}
