package ir.hri.service.impl;

import ir.hri.repository.UserRepository;
import ir.hri.entities.User;
import ir.hri.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope(value = "singleton")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void insertUser(User user) {
        userRepository.insertUser(user);
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.getUserById(userId);
    }

    @Override
    public User getUser(String username) {
        return userRepository.getUser(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }
}
