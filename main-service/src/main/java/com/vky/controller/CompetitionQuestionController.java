package com.vky.controller;

import com.vky.dto.request.CompetitionQuestionsRequestDto;
import com.vky.exception.ErrorType;
import com.vky.exception.MainManagerException;
import com.vky.mapper.ICompetitionMapper;
import com.vky.repository.entity.CompetitionQuestions;
import com.vky.service.CompetitionQuestionsService;
import com.vky.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static com.vky.constants.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL + MAIN + COMPETITION_QUESTION)
@RequiredArgsConstructor
public class CompetitionQuestionController {
    private final CompetitionQuestionsService competitionQuestionsService;
    private final JwtTokenManager jwtTokenManager;

    @PostMapping(CREATE)
    public ResponseEntity<CompetitionQuestions> createCompetitionsQuestion(@RequestBody CompetitionQuestionsRequestDto competitionQuestionsRequestDto)
    {
        try {
        Optional<Long> userId = jwtTokenManager.getUserId(competitionQuestionsRequestDto.getToken());
        if(userId.isEmpty()) throw new MainManagerException(ErrorType.INVALID_TOKEN);
        return ResponseEntity.ok(competitionQuestionsService.createCompetitionQuestion(competitionQuestionsRequestDto));
        }catch (Exception e)
        {
            throw new MainManagerException(ErrorType.INVALID_TOKEN);
        }
    }
}
