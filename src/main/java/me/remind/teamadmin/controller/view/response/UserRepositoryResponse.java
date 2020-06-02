package me.remind.teamadmin.controller.view.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRepositoryResponse {

    private String repositoryUrl;

    private String programmingLanguage;

    public static final class UserRepositoryResponseBuilder {
        private String repositoryUrl;
        private String programmingLanguage;

        private UserRepositoryResponseBuilder() {
        }

        public static UserRepositoryResponseBuilder anUserRepositoryResponse() {
            return new UserRepositoryResponseBuilder();
        }

        public UserRepositoryResponseBuilder withRepositoryUrl(String repositoryUrl) {
            this.repositoryUrl = repositoryUrl;
            return this;
        }

        public UserRepositoryResponseBuilder withProgrammingLanguage(String programmingLanguage) {
            this.programmingLanguage = programmingLanguage;
            return this;
        }

        public UserRepositoryResponse build() {
            UserRepositoryResponse userRepositoryResponse = new UserRepositoryResponse();
            userRepositoryResponse.setRepositoryUrl(repositoryUrl);
            userRepositoryResponse.setProgrammingLanguage(programmingLanguage);
            return userRepositoryResponse;
        }
    }
}
