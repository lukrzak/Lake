package com.lukrzak.lake.lake.services;

import com.lukrzak.lake.lake.dto.AddUserToTeamDto;
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
        AddUserToTeamDto adminUser = new AddUserToTeamDto();
        adminUser.setTeam_id(team.getId());
        adminUser.setUser(team.getAdmin());
        addUserToTeam(adminUser);
        System.out.println("Team" + team.getName() + " added successfully");
    }

    public void addUserToTeam(AddUserToTeamDto addUserToTeamDto){
        Team team = teamRepository.getTeamById(addUserToTeamDto.getTeam_id());
        addUserToTeamDto.getUser().addUserToTeam(team);
        teamRepository.save(team);
        userRepository.save(addUserToTeamDto.getUser());
        System.out.println("Added " + addUserToTeamDto.getUser().getLogin() + " user to team "
                + addUserToTeamDto.getTeam_id().toString());
    }
}
