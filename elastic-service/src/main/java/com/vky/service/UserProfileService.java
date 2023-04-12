package com.vky.service;


import com.vky.repository.IUserProfileRepository;
import com.vky.repository.entity.UserProfile;
import com.vky.util.ServiceManager;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserProfileService extends ServiceManager<UserProfile, Long> {
    private final IUserProfileRepository userProfileRepository;

    public UserProfileService(IUserProfileRepository userProfileRepository) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
    }

    public List<UserProfile> findAllByUserName(String userName){
        Pageable pageable = Pageable.ofSize(1000);
        return userProfileRepository.findAllByUserName(userName, pageable);
    }

    public List<String> findAllEmailList()
    {
        return userProfileRepository.findAllEmailList();
    }

    public List<UserProfile> findTop1000()
    {
        Pageable pageable = Pageable.ofSize(1000);
        return userProfileRepository.findAll(pageable).getContent();
    }
}
