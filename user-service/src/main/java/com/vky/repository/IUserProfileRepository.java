package com.vky.repository;

import com.vky.repository.entity.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserProfileRepository extends MongoRepository<UserProfile, Long> {

    @Query("SELECT COUNT(a)>0 FROM UserProfile a WHERE  a.authid = ?1")
    Boolean isExists(Long authid);

    Optional<UserProfile> findOptionalByAuthid(Long authid);

}
