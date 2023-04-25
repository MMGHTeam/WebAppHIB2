package ir.mmghteam.springmvc.service;

import ir.mmghteam.springmvc.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> list();

    void delete(Long id);

    void update(User user);

    User getById(Long id);

    void deleteUserById(Long id);
}
