package com.vky.repository;

import com.vky.repository.entity.UserProfile;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface IUserProfileRepository extends ElasticsearchRepository<UserProfile, Long> {

//    @Query("SELECT COUNT(a)>0 FROM UserProfile a WHERE  a.authid = ?1")
//    Boolean isExists(Long authid);
//
//    Optional<UserProfile> findOptionalByAuthid(Long authid);

    List<UserProfile> findAllByUserName(String userName, Pageable pageable);

    @Query("SELECT u.email FROM UserProfile u")
    List<String> findAllEmailList();


}
