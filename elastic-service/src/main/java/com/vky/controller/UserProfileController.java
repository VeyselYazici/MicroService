package com.vky.controller;

import com.vky.repository.entity.UserProfile;
import com.vky.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.vky.constants.ApiUrls.*;
@RestController
@RequestMapping(BASE_URL + USER)
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;
    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody UserProfile userProfile)
    {
        userProfileService.save(userProfile);
        return ResponseEntity.ok(true);
    }

    @PostMapping(UPDATE)
    public ResponseEntity<Boolean> update(@RequestBody UserProfile userProfile)
    {
        userProfileService.update(userProfile);
        return ResponseEntity.ok(true);
    }

    @PostMapping(DELETE)
    public ResponseEntity<Boolean> delete(@RequestBody UserProfile userProfile)
    {
        userProfileService.delete(userProfile);
        return ResponseEntity.ok(true);
    }

    @GetMapping(FINDALL)
    public ResponseEntity<Iterable<UserProfile>> findAll()
    {
        Long start = System.currentTimeMillis();
        Iterable<UserProfile> userProfiles = userProfileService.findAll();
        Long end = System.currentTimeMillis();
        System.out.println(end -start);
        return ResponseEntity.ok(userProfiles);
    }
}
