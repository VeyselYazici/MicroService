package com.vky.mapper;

import com.vky.dto.request.SaveQuestionDto;
import com.vky.repository.entity.Questions;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-04T20:04:03+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class SaveQuestionMapperImpl implements SaveQuestionMapper {

    @Override
    public Questions toQuestion(SaveQuestionDto saveQuestionDto) {
        if ( saveQuestionDto == null ) {
            return null;
        }

        Questions.QuestionsBuilder questions = Questions.builder();

        questions.question( saveQuestionDto.getQuestion() );
        questions.time( saveQuestionDto.getTime() );
        questions.ownerUserId( saveQuestionDto.getOwnerUserId() );
        questions.numberOfAnswer( saveQuestionDto.getNumberOfAnswer() );

        return questions.build();
    }
}
