package com.vky.service;

import com.vky.dto.request.CompetitionRequestDto;
import com.vky.mapper.ICompetitionMapper;
import com.vky.repository.ICompetitionRepository;
import com.vky.repository.entity.Competition;
import com.vky.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CompetitionService extends ServiceManager<Competition, Long> {
    private final ICompetitionRepository competitionRepository;

    public CompetitionService(ICompetitionRepository competitionRepository) {
        super(competitionRepository);
        this.competitionRepository = competitionRepository;
    }
    public Competition save(CompetitionRequestDto competitionRequestDto)
    {
        return save(ICompetitionMapper.INSTANCE.toCompetition(competitionRequestDto));
    }
}
