package me.remind.teamadmin.client.github;

import java.util.List;

public interface IGitHubClient {

    List<GitHubRepoResult> getRepositories(String username);
}
