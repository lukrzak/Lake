package com.lukrzak.lake.lake.dto;

import com.lukrzak.lake.lake.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserToTeamDto {
    private Long team_id;
    private User user;
}
