package me.remind.teamadmin.controller;

import io.swagger.annotations.Api;
import me.remind.teamadmin.controller.swagger.IUserRepoCtrlDoc;
import me.remind.teamadmin.controller.view.mapper.IMapUserRepo;
import me.remind.teamadmin.controller.view.response.UserRepositoryResponse;
import me.remind.teamadmin.service.IUserRepoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users/{id}/repositories")
@Api(value = "/users/{id}/repositories", description = "Team member repositories", tags = "team-repository-service")
public class UserRepoController implements IUserRepoCtrlDoc {

    private static final Logger log = LoggerFactory.getLogger(UserRepoController.class);

    private final IMapUserRepo mapUserRepo;

    private final IUserRepoService userRepositoryService;

    public UserRepoController(IMapUserRepo mapUserRepo, IUserRepoService userRepositoryService) {
        this.mapUserRepo = mapUserRepo;
        this.userRepositoryService = userRepositoryService;
    }

    @Override
    @GetMapping(value = "/github", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserRepositoryResponse> getAllGitHubRepository(@PathVariable("id") Long userId) {
        log.info("Get all GitHub repositories called with user {}", userId);
        var results = userRepositoryService.getGitRepository(userId);
        return mapUserRepo.mapToUserRepoResponse(results);
    }
}
