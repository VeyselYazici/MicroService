package com.vky.repository;

import com.vky.repository.entity.CompetitionQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompetitionQuestionsRepository extends JpaRepository<CompetitionQuestions, Long> {
}
