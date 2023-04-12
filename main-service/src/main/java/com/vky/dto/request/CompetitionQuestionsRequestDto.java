package com.vky.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompetitionQuestionsRequestDto {
    String Token;
    Long questionId;
    Long competitionId;
    Long time;
}
