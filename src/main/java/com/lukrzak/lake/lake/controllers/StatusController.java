package com.lukrzak.lake.lake.controllers;

import com.lukrzak.lake.lake.models.Event;
import com.lukrzak.lake.lake.models.Status;
import com.lukrzak.lake.lake.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StatusController {

    @Autowired
    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping("/status")
    public void addNewStatus(@RequestBody Status status){
        statusService.addNewStatus(status);
    }
}
