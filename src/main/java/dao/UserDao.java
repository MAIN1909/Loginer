package dao;

import entity.User;

import java.util.List;

public interface UserDao {
    List<User> get();

    void save(User user);

    List<User> getByLogin(String login);
}
