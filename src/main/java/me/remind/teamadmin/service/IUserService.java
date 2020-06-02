package me.remind.teamadmin.service;

import me.remind.teamadmin.entity.User;

import java.util.List;

public interface IUserService {

    User addUser(User user);

    User getUser(Long id);

    List<User> getAllUsers();

    User updateUser(Long id, User updatedUser);

    void removeUser(Long id);
}
