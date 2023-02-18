package com.lukrzak.lake.lake.services;

import com.lukrzak.lake.lake.models.Team;
import com.lukrzak.lake.lake.models.User;
import com.lukrzak.lake.lake.repositories.TeamRepository;
import com.lukrzak.lake.lake.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    private final TeamRepository teamRepository;
    @Autowired
    private final UserRepository userRepository;

    public TeamService(TeamRepository teamRepository, UserRepository userRepository) {
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
    }

    public List<Team> getAllTeamsOfGivenUserId(Long id){
        return teamRepository.getAllTeamsOfGivenUserId(id);
    }

    public void addNewTeam(Team team){
        teamRepository.save(team);
        addUserToTeam(team.getAdmin(), team.getId());
        System.out.println("Team" + team.getName() + " added successfully");
    }

    public void addUserToTeam(User user, Long id){
        Team team = teamRepository.getTeamById(id);
        user.addUserToTeam(team);
        teamRepository.save(team);
        userRepository.save(user);
        System.out.println("Added " + user.getLogin() + " user to team " + id.toString());
    }
}
