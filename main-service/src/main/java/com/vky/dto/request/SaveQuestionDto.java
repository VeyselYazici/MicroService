package com.vky.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SaveQuestionDto {
    private String token;
    private String question;
    private int time;
    private Long ownerUserId;
    private int  numberOfAnswer;
}
