package com.vky.mapper;


import com.vky.dto.request.SaveAnswerDto;
import com.vky.repository.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SaveAnswerMapper {
    SaveAnswerMapper INSTANCE = Mappers.getMapper(SaveAnswerMapper.class);
    Answer toAnswer(SaveAnswerDto saveAnswerDto);
}
