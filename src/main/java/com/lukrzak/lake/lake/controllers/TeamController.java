package com.lukrzak.lake.lake.controllers;

import com.lukrzak.lake.lake.models.Team;
import com.lukrzak.lake.lake.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TeamController {
    @Autowired
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams/{id}")
    public List<Team> getAllTeamsOfGivenUserId(@PathVariable Long id){
        return teamService.getAllTeamsOfGivenUserId(id);
    }
}
