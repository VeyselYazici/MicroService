package com.vky.controller;

import com.vky.dto.request.EditProfileRequestDto;
import com.vky.dto.request.NewUserCreateDto;
import com.vky.exception.ErrorType;
import com.vky.exception.UserManagerException;
import com.vky.repository.entity.UserProfile;
import com.vky.service.UserProfileService;
import com.vky.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;


import static com.vky.constants.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL + USER)
@RequiredArgsConstructor
@Slf4j
public class UserProfileController {
    private final UserProfileService userProfileService;
    private final JwtTokenManager jwtTokenManager;

    @CrossOrigin(originPatterns = "*")
    @PostMapping(NEW_CREATE_USER)
    public ResponseEntity<Boolean> newUserCreate(@RequestBody @Valid NewUserCreateDto userCreateDto)
    {
        try {
            userProfileService.createUserProfile(userCreateDto);
            return ResponseEntity.ok(true);
        }catch (Exception e)
        {
            throw new UserManagerException(ErrorType.USER_DONT_CREATE);
        }
    }
    @CrossOrigin(originPatterns = "*")
    @PostMapping(UPDATE_PROFILE)
    public ResponseEntity<Boolean> updateProfile(@RequestBody @Valid EditProfileRequestDto editProfileRequestDto)
    {

        try{
//            Long authid = Long.parseLong(editProfileRequestDto.getToken().substring(3,editProfileRequestDto.getToken().indexOf("X")));
            Optional<Long> authid = jwtTokenManager.getUserId(editProfileRequestDto.getToken());
            if(authid.isEmpty()) throw new UserManagerException(ErrorType.INVALID_TOKEN);
            return ResponseEntity.ok(userProfileService.updateUserProfile(editProfileRequestDto, authid.get()));
        }catch (Exception e)
        {
            throw new UserManagerException(ErrorType.INVALID_TOKEN);
        }


    }
    @CrossOrigin(originPatterns = "*")
    @GetMapping(FINDALL_PAGEABLE)
    public ResponseEntity<Page<UserProfile>> findAll(int currentPage, int pageSize, String sortParameter, String direction)
    {
        return ResponseEntity.ok(userProfileService.findAllPage(currentPage, pageSize,  sortParameter,  direction));
    }
    @CrossOrigin(originPatterns = "*")
    @GetMapping(FINDALL)
    public ResponseEntity<List<UserProfile>> findAll()
    {
        Long start = System.currentTimeMillis();
        List<UserProfile> userProfiles = userProfileService.findAll();
        Long end = System.currentTimeMillis();
        System.out.println(end -start);
        return ResponseEntity.ok(userProfiles);
    }
    @CrossOrigin(originPatterns = "*")
    @GetMapping(FINDALL_SLICE)
    public ResponseEntity<Slice<UserProfile>> findAllSlice(int currentPage, int pageSize, String sortParameter, String direction)
    {
        return ResponseEntity.ok(userProfileService.findAllSlice(currentPage, pageSize,  sortParameter,  direction));
    }
    @CrossOrigin(originPatterns = "*")
    @GetMapping("/findallcriteria/{page}/{size}/{sortparameter}/{direction}")
    public ResponseEntity<Slice<UserProfile>> findAllCriteria(@PathVariable int page,
                                                              @PathVariable int size,
                                                              @PathVariable String sortparameter,
                                                              @PathVariable String direction)
    {
        return ResponseEntity.ok(userProfileService.findAllSlice(page, size,  sortparameter,  direction));
    }
    
    @GetMapping("/redis")
    @Cacheable(value = "hello_redis")
    public String helloRedis(String message)
    {
        try {
            Thread.sleep(3000);
            return "Mesajiniz       : " + message;
        }catch (Exception e)
        {
            log.error("HATA");
            return "HATA";
        }
    }

    @GetMapping("/getall")
    public List<UserProfile> getAll()
    {
        log.info("Tum kullanicilar getirildi");
        return userProfileService.getAllCache();
    }
    @GetMapping("/clearcache")
    public void clearCache(String key, String parameter)
    {
        userProfileService.clearCache(key, parameter);
    }
}
