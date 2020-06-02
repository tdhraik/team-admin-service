package me.remind.teamadmin.controller.view.mapper;

import me.remind.teamadmin.controller.view.request.UserRequest;
import me.remind.teamadmin.controller.view.response.UserResponse;
import me.remind.teamadmin.entity.User;
import org.springframework.stereotype.Component;


@Component
public class MapUser implements IMapUser {

    @Override
    public User mapToUser(UserRequest userRequest) {
        return User.UserBuilder.anUser()
                .withFirstName(userRequest.getFirstName())
                .withSurName(userRequest.getSurName())
                .withPosition(userRequest.getPosition())
                .withGithubProfileUrl(userRequest.getGithubProfileUrl())
                .build();
    }

    @Override
    public UserRequest mapToUserRequest(User user) {
        return UserRequest.UserRequestBuilder.anUserRequest()
                .withFirstName(user.getFirstName())
                .withSurName(user.getSurName())
                .withPosition(user.getPosition())
                .withGithubProfileUrl(user.getGithubProfileUrl())
                .build();
    }

    @Override
    public UserResponse mapToUserResponse(User user) {
        return UserResponse.UserResponseBuilder.anUserResponse()
                .withId(user.getId())
                .withFirstName(user.getFirstName())
                .withSurName(user.getSurName())
                .withPosition(user.getPosition())
                .withGithubProfileUrl(user.getGithubProfileUrl())
                .build();
    }

}
