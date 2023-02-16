package com.lukrzak.lake.lake.services;

import com.lukrzak.lake.lake.models.Event;
import com.lukrzak.lake.lake.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEventsOfGivenTeamId(Long id){
        return eventRepository.getAllEventsOfGivenTeamId(id);
    }
}
