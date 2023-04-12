package com.vky.controller;

import com.vky.dto.request.CompetitionRequestDto;
import com.vky.exception.ErrorType;
import com.vky.exception.MainManagerException;
import com.vky.repository.entity.Competition;
import com.vky.service.CompetitionService;
import com.vky.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.vky.constants.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL + MAIN + COMPETITION)
@RequiredArgsConstructor
public class CompetitionController {
    private final CompetitionService competitionService;
    private final JwtTokenManager jwtTokenManager;
    @PostMapping(CREATE)
    public ResponseEntity<Competition> createCompetition(CompetitionRequestDto competitionRequestDto)
    {
        try {
            Optional<Long> userId = jwtTokenManager.getUserId(competitionRequestDto.getToken());
            if(userId.isEmpty()) throw new MainManagerException(ErrorType.INVALID_TOKEN);
            return ResponseEntity.ok(competitionService.save(competitionRequestDto));
        }catch (Exception e)
        {
            throw new MainManagerException(ErrorType.INVALID_TOKEN);
        }
    }

}
