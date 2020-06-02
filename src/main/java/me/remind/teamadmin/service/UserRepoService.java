package me.remind.teamadmin.service;

import me.remind.teamadmin.client.github.GitHubRepoResult;
import me.remind.teamadmin.client.github.IGitHubClient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class UserRepoService implements IUserRepoService {

    private IUserService userService;

    private final IGitHubClient gitHubClient;

    public UserRepoService(UserService userService, IGitHubClient gitHubClient) {
        this.userService = userService;
        this.gitHubClient = gitHubClient;
    }

    @Override
    @Cacheable(value = "user-repositories", key = "#id")
    public List<GitHubRepoResult> getGitRepository(Long id) {
        var user = userService.getUser(id);
        return gitHubClient.getRepositories(extractUsername(user.getGithubProfileUrl()));
    }

    private String extractUsername(String gitHubProfileUrl) {
        try{
            URL url = new URL(gitHubProfileUrl);
            String username = url.getPath();
            if(username.endsWith("/")) {
                username = username.substring(0, username.length()-1);
            }
            return username;
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Invalid GitHub profile url for this user.");
        }
    }
}
