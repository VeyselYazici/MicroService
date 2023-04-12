package com.vky.service;

import com.vky.dto.request.EditProfileRequestDto;
import com.vky.dto.request.NewUserCreateDto;
import com.vky.mapper.IUserProfileMapper;
import com.vky.repository.IUserProfileRepository;
import com.vky.repository.entity.UserProfile;
import com.vky.utility.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile, Long> {
    private final IUserProfileRepository userProfileRepository;
    @Autowired
    private CacheManager cacheManager;

    public UserProfileService(IUserProfileRepository userProfileRepository) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile createUserProfile(NewUserCreateDto userCreateDto)
    {
        return save(UserProfile.builder()
            .authid(userCreateDto.getAuthid())
            .userName(userCreateDto.getUserName())
            .email(userCreateDto.getEmail())
            .build());
    }

    public Boolean updateUserProfile(EditProfileRequestDto editProfileRequestDto, Long authid)
    {
        UserProfile userProfile = IUserProfileMapper.INSTANCE.toUserProfile(editProfileRequestDto);
        Optional<UserProfile> optionalUserProfile = userProfileRepository.findOptionalByAuthid(authid);
        if(optionalUserProfile.isEmpty())
        {
            return false;
        }
        try{
            userProfile.setId(optionalUserProfile.get().getId());
//            userProfile.setAuthid(optionalUserProfile.get().getAuthid());
            update(userProfile);

            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

    public Page<UserProfile> findAllPage(int currentPage, int pageSize, String sortParameter, String direction)
    {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortParameter);
        Pageable pageable = PageRequest.of(currentPage, pageSize, sort);
        return userProfileRepository.findAll(pageable);
    }

    public Slice<UserProfile> findAllSlice(int currentPage, int pageSize, String sortParameter, String direction)
    {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortParameter);
        Pageable pageable = PageRequest.of(currentPage, pageSize, sort);
        return userProfileRepository.findAll(pageable);
    }


    public void clearCache(String key, String parameter)
    {
        cacheManager.getCache(key).evict(parameter);
    }

    /**
     * [Method adi] :: [Deger] -> id
     * Clear ->
     * @return
     */
    @Cacheable(value = "userprofile_getall")
    public List<UserProfile> getAllCache()
    {
        return userProfileRepository.findAll();
    }
}
