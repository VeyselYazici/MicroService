package com.vky.mapper;


import com.vky.dto.request.SaveQuestionDto;
import com.vky.repository.entity.Questions;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SaveQuestionMapper {
    SaveQuestionMapper INSTANCE = Mappers.getMapper(SaveQuestionMapper.class);



    Questions toQuestion(SaveQuestionDto saveQuestionDto);
}
