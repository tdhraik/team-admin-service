package me.remind.teamadmin.controller.swagger;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import me.remind.teamadmin.controller.view.response.UserRepositoryResponse;
import me.remind.teamadmin.controller.view.response.UserResponse;

import java.util.List;

public interface IUserRepoCtrlDoc {

    @ApiOperation(value = "Get team member's github repositories",
            responseContainer = "List", response = UserResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "NOT_FOUND")
    })
    List<UserRepositoryResponse> getAllGitHubRepository(@ApiParam Long userId);
}
