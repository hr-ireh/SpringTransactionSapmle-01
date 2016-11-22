package ir.hri.repository;

import ir.hri.entities.User;

import java.util.List;

public interface UserRepository {

    void insertUser(User user);

    User getUserById(int userId);

    User getUser(String username);

    List<User> getUsers();
}
