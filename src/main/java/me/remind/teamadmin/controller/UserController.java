package me.remind.teamadmin.controller;


import io.swagger.annotations.Api;
import me.remind.teamadmin.controller.swagger.UserControllerDoc;
import me.remind.teamadmin.controller.view.mapper.IMapUser;
import me.remind.teamadmin.controller.view.request.UserRequest;
import me.remind.teamadmin.controller.view.response.UserResponse;
import me.remind.teamadmin.entity.User;
import me.remind.teamadmin.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
@Api(value = "/user", description = "Team member management", tags = "team-management-service")
public class UserController implements UserControllerDoc {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final IMapUser mapUser;

    private final IUserService userService;

    public UserController(IUserService userService, IMapUser mapUser) {

        this.userService = userService;
        this.mapUser = mapUser;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse addUser(@RequestBody @Valid UserRequest userRequest) {
        var user = mapUser.mapToUser(userRequest);
        user = userService.addUser(user);
        return mapUser.mapToUserResponse(user);
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUser(@PathVariable("id") Long userId) {
        log.info("Get user called with user {}", userId);
        var user = userService.getUser(userId);
        return mapUser.mapToUserResponse(user);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(mapUser::mapToUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserResponse updateUser(@PathVariable("id") Long userId, @RequestBody @Valid UserRequest userRequest) {
        log.info("Update user called with user {}", userId);
        var user = mapUser.mapToUser(userRequest);
        user = userService.updateUser(userId, user);
        return mapUser.mapToUserResponse(user);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUser(@PathVariable("id") Long userId) {
        log.info("Remove user called with user {}", userId);
        userService.removeUser(userId);
    }

}
