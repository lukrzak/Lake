package com.lukrzak.lake.lake;

import com.lukrzak.lake.lake.controllers.UserController;
import com.lukrzak.lake.lake.models.User;
import com.lukrzak.lake.lake.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.verify;

@WebMvcTest(UserController.class)
public class UserTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserService userService;
    @Captor
    private ArgumentCaptor<User> userCaptor;

    @Test
    public void create_users_returnIsCreated() throws Exception {
        User user = new User("testlogin", "testemail");
        String userJson = "{\"login\":\"testlogin\",\"email\":\"testemail\"}";

        MvcResult result = mockMvc.perform(post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isCreated())
                .andReturn();

        verify(userService).addNewUser(userCaptor.capture());
        User capturedUser = userCaptor.getValue();
        assertEquals(user.getLogin(), capturedUser.getLogin());
        assertEquals(user.getEmail(), capturedUser.getEmail());
    }


}
