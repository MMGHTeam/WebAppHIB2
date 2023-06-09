package ir.mmghteam.springmvc.service;

import ir.mmghteam.springmvc.dao.UserDao;
import ir.mmghteam.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> list() {
        return userDao.list();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(userDao.getById(id));
    }

    @Override
    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    @Transactional
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userDao.delete(userDao.getById(id));
    }


}
