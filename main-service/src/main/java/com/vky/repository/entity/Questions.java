package com.vky.repository.entity;

import com.vky.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tbl_questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 1000)
    String question;
    int time;
    @Column(name = "owner_user_id")
    Long ownerUserId;
    @Column(name = "number_of_answer")
    int numberOfAnswer;
    @Column(name = "group_name")
    String groupName;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    State state = State.ONAYDA;
    @Embedded
    TableAdd tableAdd;


}
