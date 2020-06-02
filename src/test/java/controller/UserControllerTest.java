package controller;

import me.remind.teamadmin.entity.User;
import me.remind.teamadmin.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@WebMvcTest
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IUserService userService;

    //@Test
    public void whenGetAllUsersIsCalled_thenShouldReturnAllExistingUsers() throws Exception {
        // arrange
        given(userService.getAllUsers()).willReturn(
                Arrays.asList(new User(1L, "test", "user", "Backend Dev", "https://github.com/test_user"),
                        new User(1L, "test", "user", "Backend Dev", "https://github.com/test_user")));

        // act and assert
        mvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length").value(2));
    }
}
