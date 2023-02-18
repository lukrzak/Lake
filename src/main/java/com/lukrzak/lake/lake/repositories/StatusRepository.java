package com.lukrzak.lake.lake.repositories;

import com.lukrzak.lake.lake.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    @Query(value = "SELECT * FROM status s WHERE s.event.id = :id", nativeQuery = true)
    List<Status> getAllStatusesForEvent(Long id);
}
