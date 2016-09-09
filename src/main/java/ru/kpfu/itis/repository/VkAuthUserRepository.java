package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.aspect.ReadOnlyConnection;
import ru.kpfu.itis.aspect.WriteConnection;
import ru.kpfu.itis.model.VkAuthUser;
import ru.kpfu.itis.model.enums.AuthorityType;

/**
 * Created by Юлия on 02.09.2016.
 */
@Transactional
@Repository
public interface VkAuthUserRepository extends JpaRepository<VkAuthUser, String> {

    @ReadOnlyConnection
    VkAuthUser findOneByUsernameAndType(String identificationName, AuthorityType type);

    @Modifying
    @WriteConnection
    @Query("update VkAuthUser u set u.accessToken = ?2, u.firstName = ?3, u.lastName = ?4, u.photo = ?5 where u.id = ?1")
    void updateUserInfoById(String id, String accessToken, String firstName, String lastName, String photo);
}
