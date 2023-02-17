package com.lukrzak.lake.lake.repositories;

import com.lukrzak.lake.lake.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query(value = "FROM events e WHERE e.team.id = :id", nativeQuery = true)
    List<Event> getAllEventsOfGivenTeamId(Long id);
}
