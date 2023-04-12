package com.vky.repository.entity;


import com.vky.repository.enums.AccessionType;
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
@Table(name = "tbl_accession")
public class Accession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "user_id")
    Long userId;
    @Column(name = "competition_id")
    Long competitionId;
    Long date;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    AccessionType accessionType = AccessionType.UNAPPROVED;
    @Embedded
    TableAdd tableAdd;
}
