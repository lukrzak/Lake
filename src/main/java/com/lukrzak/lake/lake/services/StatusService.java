package com.lukrzak.lake.lake.services;

import com.lukrzak.lake.lake.models.Status;
import com.lukrzak.lake.lake.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    @Autowired
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> getAllStatusesForEvent(Long id){
        return statusRepository.getAllStatusesForEvent(id);
    }
}
