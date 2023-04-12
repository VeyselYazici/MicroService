package com.vky.repository;

import com.vky.repository.entity.QuestionGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionGroupRepository extends JpaRepository<QuestionGroup, Long> {
}
