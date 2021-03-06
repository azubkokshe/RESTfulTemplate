package net.omisoft.rest.repository;

import net.omisoft.rest.model.FCMTokenEntity;
import net.omisoft.rest.model.UserEntity;
import net.omisoft.rest.model.base.OS;
import net.omisoft.rest.model.projection.FCMTokenProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface FCMTokenRepository extends JpaRepository<FCMTokenEntity, Long> {

    @Query("SELECT t.token AS token, t.os AS os FROM FCMTokenEntity t JOIN t.user u WHERE u.id IN :ids")
    Set<FCMTokenProjection> getTokenByIdUser(@Param("ids") Set<Long> idUsers);

    Optional<FCMTokenEntity> findByDeviceAndOsAndUser(String device, OS os, UserEntity user);

}