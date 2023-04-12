package com.vky.graphql.mutation;

import com.vky.graphql.model.UserProfileInput;
import com.vky.repository.entity.UserProfile;
import com.vky.service.UserProfileService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileMutationResolver implements GraphQLMutationResolver {
    private final UserProfileService userProfileService;
    public Boolean createUserProfile(UserProfileInput profile)
    {
        userProfileService.save(UserProfile.builder()
                .id(5000L)
                .authid(profile.getAuthid())
                .userName(profile.getUserName())
                .name(profile.getName())
                .surName(profile.getSurName())
                .email(profile.getEmail()).build());
        return true;
    }
}
