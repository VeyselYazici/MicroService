package com.vky.util;


import com.vky.manager.IUserManager;
import com.vky.repository.entity.UserProfile;
import com.vky.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserImpl {

    private final UserProfileService userProfileService;

    private final IUserManager userManager;
    @PostConstruct
    public void init()
    {
        List<UserProfile> userProfileList = userManager.findAll().getBody();
        userProfileService.saveAll(userProfileList);
//        userManager.findAll().getBody().forEach(x ->{
//            userProfileService.save(UserProfile.builder()
//                    .email(x.getEmail())
//                    .userName(x.getUserName())
//                    .name(x.getName())
//                    .id(x.getAuthid()).build());
//        });
    }

}
