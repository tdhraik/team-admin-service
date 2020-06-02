package me.remind.teamadmin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;

    private String surName;

    private String position;

    private String githubProfileUrl;

    public static final class UserBuilder {
        private Long id;
        private String firstName;
        private String surName;
        private String position;
        private String githubProfileUrl;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withSurName(String surName) {
            this.surName = surName;
            return this;
        }

        public UserBuilder withPosition(String position) {
            this.position = position;
            return this;
        }

        public UserBuilder withGithubProfileUrl(String githubProfileUrl) {
            this.githubProfileUrl = githubProfileUrl;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(id);
            user.setFirstName(firstName);
            user.setSurName(surName);
            user.setPosition(position);
            user.setGithubProfileUrl(githubProfileUrl);
            return user;
        }
    }
}
