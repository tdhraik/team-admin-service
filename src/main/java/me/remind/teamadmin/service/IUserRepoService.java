package me.remind.teamadmin.service;

import me.remind.teamadmin.client.github.GitHubRepoResult;

import java.util.List;

public interface IUserRepoService {

    List<GitHubRepoResult> getGitRepository(Long id);
}
