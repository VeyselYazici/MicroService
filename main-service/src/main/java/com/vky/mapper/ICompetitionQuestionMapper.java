package com.vky.mapper;

import com.vky.dto.request.CompetitionQuestionsRequestDto;
import com.vky.dto.request.CompetitionRequestDto;
import com.vky.repository.entity.CompetitionQuestions;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICompetitionQuestionMapper {
    ICompetitionQuestionMapper INSTANCE = Mappers.getMapper(ICompetitionQuestionMapper.class);

    CompetitionQuestions toCompetitionQuestions(CompetitionQuestionsRequestDto competitionQuestionsRequestDto);
}
