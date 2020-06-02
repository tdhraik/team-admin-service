package me.remind.teamadmin.controller.swagger;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import me.remind.teamadmin.controller.view.request.UserRequest;
import me.remind.teamadmin.controller.view.response.UserResponse;

import java.util.List;

public interface UserControllerDoc {


    @ApiOperation(value = "Add a team member", response = UserResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "CREATED"),
            @ApiResponse(code = 400, message = "BAD_REQUEST")
    })
    UserResponse addUser(@ApiParam UserRequest userRequest);

    @ApiOperation(value = "Get a team member", response = UserResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "NOT_FOUND")
    })
    UserResponse getUser(@ApiParam Long id);

    @ApiOperation(value = "Get all team members", responseContainer = "List",
                    response = UserResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD_REQUEST")
    })
    List<UserResponse> getAllUsers();


    @ApiOperation(value = "Update a team member", response = UserResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "NOT_FOUND")
    })
    UserResponse updateUser(@ApiParam Long id, @ApiParam UserRequest userRequest);


    @ApiOperation(value = "Remove a team member")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "DELETED"),
            @ApiResponse(code = 404, message = "NOT_FOUND")
    })
    void removeUser(@ApiParam Long id);


}
