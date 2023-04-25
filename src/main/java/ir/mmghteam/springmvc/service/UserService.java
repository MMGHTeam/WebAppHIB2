package ir.mmghteam.springmvc.service;

import ir.mmghteam.springmvc.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> list();

    void delete(Long id);

    Object get(Long id);

    void update(User user);
}
