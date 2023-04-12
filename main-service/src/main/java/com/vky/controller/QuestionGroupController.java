package com.vky.controller;

import com.vky.dto.request.QuestionGroupRequestDto;
import com.vky.exception.ErrorType;
import com.vky.exception.MainManagerException;
import com.vky.repository.entity.QuestionGroup;
import com.vky.service.QuestionGroupService;
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
@RequestMapping(BASE_URL + MAIN + QUESTION_GROUP)
@RequiredArgsConstructor
public class QuestionGroupController {
    private final QuestionGroupService questionGroupService;
    private final JwtTokenManager jwtTokenManager;
    @PostMapping(CREATE)
    public ResponseEntity<QuestionGroup> createQuestionGroup(@RequestBody @Valid QuestionGroupRequestDto questionGroupRequestDto)
    {
        try{
            Optional<Long> userId = jwtTokenManager.getUserId(questionGroupRequestDto.getToken());
            if(userId.isEmpty()) throw new MainManagerException(ErrorType.INVALID_TOKEN);
            /**
             * Burada gelen userId nin ilgili islemi yapabilecek yetkisinin olup olmadigi kontrol edilerek
             * isleme izin verilmelidir.
             */
             return ResponseEntity.ok(questionGroupService.save(QuestionGroup.builder()
                     .groupName(questionGroupRequestDto.getGroupName())
                     .build()));
        }catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }

    }
}
