package com.lukrzak.lake.lake.repositories;

import com.lukrzak.lake.lake.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query(value = "SELECT * FROM teams t WHERE t.user.id = :id", nativeQuery = true)
    List<Team> getAllTeamsOfGivenUserId(Long id);

    @Query(value = "SELECT * FROM teams t WHERE t.team_id = :id", nativeQuery = true)
    Team getTeamById(Long id);
}
