package com.vky.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NewUserCreateDto {
    /**
     * yeni uyelik acmis birisinin outh_id bilgisinin tutuldugu alan
     */
    Long authid;
    String userName;
    String email;
}
