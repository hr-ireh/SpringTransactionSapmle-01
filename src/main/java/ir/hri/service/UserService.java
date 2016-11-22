package ir.hri.service;


import ir.hri.entities.User;

import java.util.List;

public interface UserService {
    void insertUser(User user);

    User getUserById(int userId);

    User getUser(String username);

    List<User> getUsers();
}
