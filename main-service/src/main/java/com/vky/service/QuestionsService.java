package com.vky.service;


import com.vky.dto.request.CreatingQuestionDto;
import com.vky.dto.request.SaveAnswerDto;
import com.vky.mapper.SaveAnswerMapper;
import com.vky.mapper.SaveQuestionMapper;
import com.vky.repository.IQuestionsRepository;
import com.vky.repository.entity.Questions;
import com.vky.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class QuestionsService extends ServiceManager<Questions, Long> {
    private final IQuestionsRepository questionsRepository;
    private final AnswerService answerService;

    public QuestionsService(IQuestionsRepository questionsRepository, AnswerService answerService) {
        super(questionsRepository);
        this.questionsRepository = questionsRepository;
        this.answerService = answerService;
    }

    public void saveQuestion(CreatingQuestionDto creatingQuestionDto)
    {
        Questions questions = SaveQuestionMapper.INSTANCE.toQuestion(creatingQuestionDto.getSaveQuestionDto());
        questionsRepository.save(questions);

        answerService.questionAnswerSave(creatingQuestionDto.getSaveAnswerDtoList(), questions.getId());

//        Questions question = save(Questions.builder()
//                .question(creatingQuestionDto.getSaveQuestionDto().getQuestion())
//                .numberOfAnswer(creatingQuestionDto.getSaveQuestionDto().getNumberOfAnswer())
//                .time(creatingQuestionDto.getSaveQuestionDto().getTime())
//                .ownerUserId(creatingQuestionDto.getSaveQuestionDto().getOwnerUserId())
//                .build());
//        /**
//         * cevapları kayıt etmeniz gerekli.
//         * 1. cevap kayıt edebnilmeniz için soru idsine ihtiyaç var
//         * 2. bir sorunun en az 2 cevabı(şıkkı) olmalı
//         */
//        answerService.questionAnswerSave(creatingQuestionDto.getSaveAnswerDtoList(), question.getId());
    }




}
