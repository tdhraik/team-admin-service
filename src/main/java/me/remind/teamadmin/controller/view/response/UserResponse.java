package me.remind.teamadmin.controller.view.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;

    private String firstName;

    private String surName;

    private String position;

    private String githubProfileUrl;

    public static final class UserResponseBuilder {
        private Long id;
        private String firstName;
        private String surName;
        private String position;
        private String githubProfileUrl;

        private UserResponseBuilder() {
        }

        public static UserResponseBuilder anUserResponse() {
            return new UserResponseBuilder();
        }

        public UserResponseBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserResponseBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserResponseBuilder withSurName(String surName) {
            this.surName = surName;
            return this;
        }

        public UserResponseBuilder withPosition(String position) {
            this.position = position;
            return this;
        }

        public UserResponseBuilder withGithubProfileUrl(String githubProfileUrl) {
            this.githubProfileUrl = githubProfileUrl;
            return this;
        }

        public UserResponse build() {
            UserResponse userResponse = new UserResponse();
            userResponse.setId(id);
            userResponse.setFirstName(firstName);
            userResponse.setSurName(surName);
            userResponse.setPosition(position);
            userResponse.setGithubProfileUrl(githubProfileUrl);
            return userResponse;
        }
    }
}
