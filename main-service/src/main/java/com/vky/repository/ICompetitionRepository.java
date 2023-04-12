package com.vky.repository;

import com.vky.repository.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompetitionRepository extends JpaRepository<Competition, Long> {
}
