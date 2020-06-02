package me.remind.teamadmin.controller.view.mapper;

import me.remind.teamadmin.controller.view.request.UserRequest;
import me.remind.teamadmin.controller.view.response.UserResponse;
import me.remind.teamadmin.entity.User;

public interface IMapUser {

    User mapToUser(UserRequest userRequest);

    UserRequest mapToUserRequest(User user);

    UserResponse mapToUserResponse(User user);

}
