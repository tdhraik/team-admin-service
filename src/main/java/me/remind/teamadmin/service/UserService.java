package me.remind.teamadmin.service;

import com.google.common.collect.Lists;
import me.remind.teamadmin.entity.User;
import me.remind.teamadmin.entity.repository.UserRepository;
import me.remind.teamadmin.exception.EntityNotFoundException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(User.class, id));
    }

    @Override
    public List<User> getAllUsers() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Override
    @CacheEvict(value = "user-repositories", key="#id")
    public User updateUser(Long id, User updateUser) {
        var user = getUser(id);
        updateUser.setId(user.getId());
        return userRepository.save(updateUser);
    }

    @Override
    @CacheEvict(value = "user-repositories", key="#id")
    public void removeUser(Long id) {
        var user = getUser(id);
        userRepository.delete(user);
    }
}
