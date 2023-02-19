package com.lukrzak.lake.lake.services;

import com.lukrzak.lake.lake.models.Status;
import com.lukrzak.lake.lake.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addNewStatus(Status status){
        statusRepository.save(status);
    }

    public void changeUserStatus(Status newStatus){
        Optional<Status> status = statusRepository.findById(newStatus.getId());
        if(status.isPresent()) {
            status.get().setStatus(newStatus.getStatus());
            statusRepository.save(status.get());
            System.out.println("Changed status " + status.get().getId() + " to " + newStatus.getStatus());
        }
    }
}
