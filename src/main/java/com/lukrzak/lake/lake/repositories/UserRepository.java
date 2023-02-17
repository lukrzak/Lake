package com.lukrzak.lake.lake.repositories;

import com.lukrzak.lake.lake.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "FROM users u WHERE u.team.id = :id", nativeQuery = true)
    List<User> getAllUsersOfGivenTeamId(Long id);
}
