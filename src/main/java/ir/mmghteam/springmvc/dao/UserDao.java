package ir.mmghteam.springmvc.dao;

import ir.mmghteam.springmvc.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    void update(User user);

    void delete(User user);

    User get(Long id);

    List<User> list();
}
