package ir.mmghteam.springmvc.dao;

import ir.mmghteam.springmvc.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    List<User> list();
}
