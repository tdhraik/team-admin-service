package me.remind.teamadmin.controller.view.mapper;

import me.remind.teamadmin.client.github.GitHubRepoResult;
import me.remind.teamadmin.controller.view.response.UserRepositoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapUserRepo implements IMapUserRepo {

    @Override
    public List<UserRepositoryResponse> mapToUserRepoResponse(List<GitHubRepoResult> results) {
        return results
                .stream()
                .map(r -> UserRepositoryResponse.UserRepositoryResponseBuilder
                    .anUserRepositoryResponse()
                    .withRepositoryUrl(r.getHtmlUrl())
                    .withProgrammingLanguage(r.getLanguage())
                    .build())
                .collect(Collectors.toList());
    }
}
