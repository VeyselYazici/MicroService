package com.vky.repository.entity;

import com.vky.repository.enums.CompetitionStatus;
import com.vky.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tbl_competitions")
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(name = "competition_owner_id")
    Long competitionOwnerId;
    String explanation;
    String title;
    String picture;
    @Column(name = "number_of_winners")
    int numberOfWinners;


    @Enumerated(EnumType.STRING)
    @Builder.Default
    CompetitionStatus competitionStatus = CompetitionStatus.ACTIVE_OPEN_TO_PARTICIPATE;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    State state = State.ONAYDA;
    @Embedded
    TableAdd tableAdd;
    @Transient
    List<Questions> questionList;

}
