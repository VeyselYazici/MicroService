package com.vky.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreatingQuestionDto {
    private String token;
    private SaveQuestionDto saveQuestionDto;
    private List<SaveAnswerDto> saveAnswerDtoList;
}
