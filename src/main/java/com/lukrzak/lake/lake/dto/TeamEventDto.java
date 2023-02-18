package com.lukrzak.lake.lake.dto;

import com.lukrzak.lake.lake.models.Event;
import lombok.Getter;

@Getter
public class TeamEventDto {
    private Long team_id;
    private Event event;
}
