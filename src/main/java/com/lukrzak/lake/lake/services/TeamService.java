package com.lukrzak.lake.lake.services;

import com.lukrzak.lake.lake.models.Team;
import com.lukrzak.lake.lake.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeamsOfGivenUserId(Long id){
        return teamRepository.getAllTeamsOfGivenUserId(id);
    }
}
