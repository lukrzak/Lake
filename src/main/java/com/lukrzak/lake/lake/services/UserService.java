package com.lukrzak.lake.lake.services;

import com.lukrzak.lake.lake.exceptions.UserLoginAlreadyTakenException;
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

    public void addNewUser(User user) throws UserLoginAlreadyTakenException {
        checkIfUserAlreadyExists(user);
        userRepository.save(user);
        System.out.println("User " + user.getLogin() + " added successfully");
    }

    public void checkIfUserAlreadyExists(User user) throws UserLoginAlreadyTakenException {
        List<User> getUserWithSameUsername = userRepository.getAllUsersWithGivenName(user.getLogin());
        if (getUserWithSameUsername.size() != 0) throw new UserLoginAlreadyTakenException();
    }
 }
