package com.lukrzak.lake.lake.services;

import com.lukrzak.lake.lake.models.User;
import com.lukrzak.lake.lake.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsersOfGivenTeamId(Long id){
        return userRepository.getAllUsersOfGivenTeamId(id);
    }
 }
