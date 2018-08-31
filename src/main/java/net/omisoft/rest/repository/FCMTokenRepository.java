package net.omisoft.rest.repository;

import net.omisoft.rest.model.FCMTokenEntity;
import net.omisoft.rest.model.UserEntity;
import net.omisoft.rest.model.base.OS;
import net.omisoft.rest.pojo.CustomFCMToken;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface FCMTokenRepository extends CrudRepository<FCMTokenEntity, Long> {

    @Query("SELECT new net.omisoft.rest.pojo.CustomFCMToken(t.token, t.os) FROM FCMTokenEntity t JOIN t.user u WHERE u.id IN :ids GROUP BY t.os")
    Set<CustomFCMToken> getTokenByIdUser(@Param("ids") Set<Long> idUsers);

    Optional<FCMTokenEntity> findByDeviceAndOsAndUser(String device, OS os, UserEntity user);

}