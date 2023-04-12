package com.vky.repository;

import com.vky.repository.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionsRepository extends JpaRepository<Questions, Long> {
}
