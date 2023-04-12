package com.vky.mapper;

import com.vky.dto.request.CompetitionQuestionsRequestDto;
import com.vky.repository.entity.CompetitionQuestions;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-05T07:51:13+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class ICompetitionQuestionMapperImpl implements ICompetitionQuestionMapper {

    @Override
    public CompetitionQuestions toCompetitionQuestions(CompetitionQuestionsRequestDto competitionQuestionsRequestDto) {
        if ( competitionQuestionsRequestDto == null ) {
            return null;
        }

        CompetitionQuestions.CompetitionQuestionsBuilder competitionQuestions = CompetitionQuestions.builder();

        competitionQuestions.questionId( competitionQuestionsRequestDto.getQuestionId() );
        competitionQuestions.competitionId( competitionQuestionsRequestDto.getCompetitionId() );
        competitionQuestions.time( competitionQuestionsRequestDto.getTime() );

        return competitionQuestions.build();
    }
}
