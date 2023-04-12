package com.vky.mapper;

import com.vky.dto.request.CompetitionRequestDto;
import com.vky.repository.entity.Competition;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICompetitionMapper {
    ICompetitionMapper INSTANCE = Mappers.getMapper(ICompetitionMapper.class);
    @Mappings({
            @Mapping(source = "userid", target = "competitionOwnerId"),
            @Mapping(source = "baslik", target = "title"),
            @Mapping(source = "tanim", target = "explanation")
    })
    Competition toCompetition(CompetitionRequestDto competitionRequestDto);
}
