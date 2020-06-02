package me.remind.teamadmin.controller.view.mapper;

import me.remind.teamadmin.client.github.GitHubRepoResult;
import me.remind.teamadmin.controller.view.response.UserRepositoryResponse;

import java.util.List;

public interface IMapUserRepo {

    List<UserRepositoryResponse> mapToUserRepoResponse(List<GitHubRepoResult> results);
}
