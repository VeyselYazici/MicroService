package com.vky.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompetitionRequestDto {
    String token;
    @NotNull
    Long userid;
    @NotNull
    String tanim;
    @NotNull
    String baslik;
    @NotNull
    String picture;
    @NotNull
    int numberOfWinners;
}
