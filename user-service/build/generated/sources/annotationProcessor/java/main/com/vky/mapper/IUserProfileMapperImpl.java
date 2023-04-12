package com.vky.mapper;

import com.vky.dto.request.EditProfileRequestDto;
import com.vky.repository.entity.UserProfile;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-12T16:14:26+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class IUserProfileMapperImpl implements IUserProfileMapper {

    @Override
    public UserProfile toUserProfile(EditProfileRequestDto editProfileRequestDto) {
        if ( editProfileRequestDto == null ) {
            return null;
        }

        UserProfile.UserProfileBuilder userProfile = UserProfile.builder();

        userProfile.userName( editProfileRequestDto.getUserName() );
        userProfile.name( editProfileRequestDto.getName() );
        userProfile.surName( editProfileRequestDto.getSurName() );
        userProfile.email( editProfileRequestDto.getEmail() );
        userProfile.phone( editProfileRequestDto.getPhone() );
        userProfile.photo( editProfileRequestDto.getPhoto() );
        userProfile.address( editProfileRequestDto.getAddress() );
        userProfile.about( editProfileRequestDto.getAbout() );

        return userProfile.build();
    }
}
