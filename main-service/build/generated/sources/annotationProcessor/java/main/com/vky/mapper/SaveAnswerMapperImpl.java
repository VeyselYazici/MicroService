package com.vky.mapper;

import com.vky.dto.request.SaveAnswerDto;
import com.vky.repository.entity.Answer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-04T20:04:03+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class SaveAnswerMapperImpl implements SaveAnswerMapper {

    @Override
    public Answer toAnswer(SaveAnswerDto saveAnswerDto) {
        if ( saveAnswerDto == null ) {
            return null;
        }

        Answer.AnswerBuilder answer = Answer.builder();

        answer.answer( saveAnswerDto.getAnswer() );

        return answer.build();
    }
}
