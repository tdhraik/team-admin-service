package me.remind.teamadmin.client.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GitHubRepoResult {

    @JsonProperty("name")
    String name;

    @JsonProperty("html_url")
    String htmlUrl;

    @JsonProperty("url")
    String url;

    @JsonProperty("language")
    String language;
}
