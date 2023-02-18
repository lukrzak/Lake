package com.lukrzak.lake.lake.controllers;

import com.lukrzak.lake.lake.dto.TeamEventDto;
import com.lukrzak.lake.lake.models.Event;
import com.lukrzak.lake.lake.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EventController {
    @Autowired
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(value = "/events/{id}")
    public List<Event> getAllEventsOfGivenTeamId(@PathVariable Long id){
        return eventService.getAllEventsOfGivenTeamId(id);
    }

    @PostMapping(value = "/events/add-event")
    public void addNewEventForTeam(@RequestBody TeamEventDto teamEventDto){
        eventService.addNewEventForTeam(teamEventDto);
    }

}
