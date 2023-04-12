package com.vky.repository;

import com.vky.repository.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAuthRepository extends JpaRepository<Auth, Long> {
    /**
     * Kullanici adi Buyuk kucuk harf duyarli olmamali.
     * Sifre buyuk kucuk harf duyarli olmali.
     */
    Optional<Auth> findOptionalByUserNameIgnoreCaseAndPassword(String userName, String password);

    @Query("SELECT COUNT(a)>0 FROM Auth a WHERE UPPER(a.userName) = UPPER(?1) and a.password = ?2")
    Boolean isExists(String userName, String password);

    @Query("SELECT COUNT(a)>0 FROM Auth a WHERE UPPER(a.userName) = UPPER(?1)")
    Boolean isExistsUserName(String userName);
}
