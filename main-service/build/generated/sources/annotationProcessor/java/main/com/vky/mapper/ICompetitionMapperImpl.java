package com.vky.mapper;

import com.vky.dto.request.CompetitionRequestDto;
import com.vky.repository.entity.Competition;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-04T20:04:03+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class ICompetitionMapperImpl implements ICompetitionMapper {

    @Override
    public Competition toCompetition(CompetitionRequestDto competitionRequestDto) {
        if ( competitionRequestDto == null ) {
            return null;
        }

        Competition.CompetitionBuilder competition = Competition.builder();

        competition.competitionOwnerId( competitionRequestDto.getUserid() );
        competition.title( competitionRequestDto.getBaslik() );
        competition.explanation( competitionRequestDto.getTanim() );
        competition.picture( competitionRequestDto.getPicture() );
        competition.numberOfWinners( competitionRequestDto.getNumberOfWinners() );

        return competition.build();
    }
}
