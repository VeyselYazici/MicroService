package com.vky.controller;

import com.vky.dto.request.CreatingQuestionDto;
import com.vky.exception.ErrorType;
import com.vky.exception.MainManagerException;
import com.vky.service.QuestionsService;
import com.vky.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

import static com.vky.constants.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL + MAIN + QUESTION)
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionsService questionsService;
    private final JwtTokenManager jwtTokenManager;
    @PostMapping(CREATE)
    public ResponseEntity<Void> createQuestion(@RequestBody @Valid CreatingQuestionDto creatingQuestionDto)
    {
        try{
            Optional<Long> userId = jwtTokenManager.getUserId(creatingQuestionDto.getToken());
            if(userId.isEmpty()) throw new MainManagerException(ErrorType.INVALID_TOKEN);
            questionsService.saveQuestion(creatingQuestionDto);
            return ResponseEntity.ok().build();
        }catch (Exception e)
        {
            throw new MainManagerException(ErrorType.INVALID_TOKEN);
        }
    }
}
