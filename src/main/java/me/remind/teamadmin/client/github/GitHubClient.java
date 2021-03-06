package me.remind.teamadmin.client.github;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Service
public class GitHubClient implements IGitHubClient {

    private static final Logger log = LoggerFactory.getLogger(GitHubClient.class);

    @Value("${client.github.baseUrl}")
    private String baseUrl;

    @Value("${client.github.token}")
    private String token;

    private RestTemplate restTemplate;

    public GitHubClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<GitHubRepoResult> getRepositories(String username) {
        log.info("Fetching results for user {} from GitHub client", username);
        var repositoriesResponse = restTemplate.exchange(getUri(username), HttpMethod.GET,
                new HttpEntity<>(createHeaders(token)), GitHubRepoResult[].class);
        return Arrays.asList(repositoriesResponse.getBody());
    }

    private URI getUri(String username) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl + username + "/repos"); // TODO: 02/06/20 can do better !!
        return builder.buildAndExpand(builder).toUri();
    }

    private HttpHeaders createHeaders(String token){
        return new HttpHeaders() {{
            String authHeader = "token " + token;
            set( "Authorization", authHeader );
        }};
    }

}
