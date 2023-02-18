package com.lukrzak.lake.lake.services;

import com.lukrzak.lake.lake.dto.TeamEventDto;
import com.lukrzak.lake.lake.models.Event;
import com.lukrzak.lake.lake.models.Team;
import com.lukrzak.lake.lake.repositories.EventRepository;
import com.lukrzak.lake.lake.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private final EventRepository eventRepository;
    @Autowired
    private final TeamRepository teamRepository;

    public EventService(EventRepository eventRepository, TeamRepository teamRepository) {
        this.eventRepository = eventRepository;
        this.teamRepository = teamRepository;
    }

    public List<Event> getAllEventsOfGivenTeamId(Long id){
        return eventRepository.getAllEventsOfGivenTeamId(id);
    }

    public void addNewEventForTeam(TeamEventDto teamEventDto){
        Team team = teamRepository.getTeamById(teamEventDto.getTeam_id());
        teamEventDto.getEvent().setTeam(team);
        eventRepository.save(teamEventDto.getEvent());
        System.out.println("Added event " + teamEventDto.getEvent().getTitle() + " to team " + team.getName());
    }
}
