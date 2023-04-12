package com.vky.service;


import com.vky.repository.IQuestionGroupRepository;
import com.vky.repository.entity.QuestionGroup;
import com.vky.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class QuestionGroupService extends ServiceManager<QuestionGroup, Long> {
    private final IQuestionGroupRepository questionGroupRepository;

    public QuestionGroupService(IQuestionGroupRepository questionGroupRepository) {
        super(questionGroupRepository);
        this.questionGroupRepository = questionGroupRepository;
    }
}
