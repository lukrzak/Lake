package com.lukrzak.lake.lake;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lukrzak.lake.lake.controllers.UserController;
import com.lukrzak.lake.lake.exceptions.UserLoginAlreadyTakenException;
import com.lukrzak.lake.lake.models.Team;
import com.lukrzak.lake.lake.models.User;
import com.lukrzak.lake.lake.repositories.UserRepository;
import com.lukrzak.lake.lake.services.UserService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.verify;


@WebMvcTest(UserController.class)
public class UserTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Captor
    private ArgumentCaptor<User> userCaptor;
    @MockBean
    UserRepository userRepository;
    @MockBean
    UserService userService;
    @MockBean
    private UserController userController;

    @Test
    public void create_users_returnIsCreated() throws Exception {
        User user = new User("testlogin", "testemail");

        MvcResult result = mockMvc.perform(post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andReturn();

        verify(userService).addNewUser(userCaptor.capture());
        User capturedUser = userCaptor.getValue();
        assertEquals(user.getLogin(), capturedUser.getLogin());
        assertEquals(user.getEmail(), capturedUser.getEmail());
    }

    @Test
    public void create_new_users_throwsUserAlreadyTakenException() throws Exception {
        User user1 = new User("login1", "email1");
        User user2 = new User("login1", "email2");

        //when(userService.addNewUser(user1)).thenReturn(user1);
        //userController.addNewUser(user1);

        MvcResult result = mockMvc.perform(post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user2)))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertTrue(result.getResolvedException() instanceof UserLoginAlreadyTakenException);

    }

    @Test
    public void get_all_team_users_returnsOk() throws Exception {
        User user1 = new User("login1", "email1");
        User user2 = new User("login2", "email2");
        User user3 = new User("login3", "email3");

        when(userRepository.getAllUsersOfGivenTeamId(1L)).thenReturn(List.of(user1, user2, user3));
        when(userRepository.getAllUsersOfGivenTeamId(2L)).thenReturn(List.of(user1, user2));

        MvcResult result1 = mockMvc.perform(get("/api/v1/users/team/1"))
                .andExpect(status().isOk())
                .andReturn();
        MvcResult result2 = mockMvc.perform(get("/api/v1/users/team/2"))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody1 = result1.getResponse().getContentAsString();
        String responseBody2 = result2.getResponse().getContentAsString();
        List<User> userList1 = objectMapper.readValue(responseBody1, new TypeReference<List<User>>() {});
        List<User> userList2 = objectMapper.readValue(responseBody2, new TypeReference<List<User>>() {});
        //assertTrue();
    }
}
