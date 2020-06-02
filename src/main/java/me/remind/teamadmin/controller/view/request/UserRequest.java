package me.remind.teamadmin.controller.view.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank(message = "First name can not be empty.")
    private String firstName;

    private String surName;

    @NotBlank(message = "Position can not be empty.")
    private String position;

    @NotBlank(message = "GitHub profile can not be empty.")
    @Pattern(regexp = "https://github\\.com(/[a-zA-Z0-9_]*)/?", message = "Invalid GitHub profile URL. Valid URL: https://github.com/{USERNAME}")
    private String githubProfileUrl;

    public static final class UserRequestBuilder {
        private String firstName;
        private String surName;
        private String position;
        private String githubProfileUrl;

        private UserRequestBuilder() {
        }

        public static UserRequestBuilder anUserRequest() {
            return new UserRequestBuilder();
        }

        public UserRequestBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserRequestBuilder withSurName(String surName) {
            this.surName = surName;
            return this;
        }

        public UserRequestBuilder withPosition(String position) {
            this.position = position;
            return this;
        }

        public UserRequestBuilder withGithubProfileUrl(String githubProfileUrl) {
            this.githubProfileUrl = githubProfileUrl;
            return this;
        }

        public UserRequest build() {
            UserRequest userRequest = new UserRequest();
            userRequest.setFirstName(firstName);
            userRequest.setSurName(surName);
            userRequest.setPosition(position);
            userRequest.setGithubProfileUrl(githubProfileUrl);
            return userRequest;
        }
    }
}
