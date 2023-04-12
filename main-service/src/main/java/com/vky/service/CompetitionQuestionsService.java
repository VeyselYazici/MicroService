package com.vky.service;


import com.vky.dto.request.CompetitionQuestionsRequestDto;
import com.vky.mapper.ICompetitionQuestionMapper;
import com.vky.repository.ICompetitionQuestionsRepository;
import com.vky.repository.entity.CompetitionQuestions;
import com.vky.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CompetitionQuestionsService extends ServiceManager<CompetitionQuestions, Long> {
    private final ICompetitionQuestionsRepository competitionQuestionsRepository;

    public CompetitionQuestionsService(ICompetitionQuestionsRepository competitionQuestionsRepository) {
        super(competitionQuestionsRepository);
        this.competitionQuestionsRepository = competitionQuestionsRepository;
    }

    public CompetitionQuestions createCompetitionQuestion(CompetitionQuestionsRequestDto competitionQuestionsRequestDto)
    {
        return save(ICompetitionQuestionMapper.INSTANCE.toCompetitionQuestions(competitionQuestionsRequestDto));
    }
}
