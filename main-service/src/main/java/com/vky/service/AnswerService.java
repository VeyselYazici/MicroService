package com.vky.service;


import com.vky.dto.request.SaveAnswerDto;
import com.vky.repository.IAnswerRepository;
import com.vky.repository.entity.Answer;
import com.vky.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService extends ServiceManager<Answer, Long> {
    private final IAnswerRepository answerRepository;

    public AnswerService(IAnswerRepository answerRepository) {
        super(answerRepository);
        this.answerRepository = answerRepository;
    }

    public void questionAnswerSave(List<SaveAnswerDto> saveAnswerDto, Long questionid)
    {
        saveAnswerDto.forEach(answer -> {
            save(Answer.builder()
                    .questionId(questionid)
                    .answer(answer.getAnswer())
                    .is_true(answer.is_true())
                    .build());
       });

    }
}
