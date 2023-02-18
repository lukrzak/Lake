package com.lukrzak.lake.lake.controllers;

import com.lukrzak.lake.lake.exceptions.UserLoginAlreadyTakenException;
import com.lukrzak.lake.lake.models.User;
import com.lukrzak.lake.lake.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/team/{id}")
    public List<User> getAllUsersOfGivenTeamId(@PathVariable Long id){
        return userService.getAllUsersOfGivenTeamId(id);
    }

    @PostMapping("/users")
    public void addNewUser(@RequestBody User user) throws UserLoginAlreadyTakenException {
        userService.addNewUser(user);
    }
}
