package com.lukrzak.lake.lake.controllers;

import com.lukrzak.lake.lake.dto.AddUserToTeamDto;
import com.lukrzak.lake.lake.models.Team;
import com.lukrzak.lake.lake.models.User;
import com.lukrzak.lake.lake.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/teams")
    public void addNewTeam(@RequestBody Team team){
        teamService.addNewTeam(team);
    }

    @PostMapping("/teams/add-user")
    public void addUserToTeam(@RequestBody AddUserToTeamDto user){
        teamService.addUserToTeam(user);
    }
}
