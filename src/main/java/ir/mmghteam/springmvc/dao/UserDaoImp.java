package ir.mmghteam.springmvc.dao;

import ir.mmghteam.springmvc.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
    @Override
    public void update(User user) { sessionFactory.getCurrentSession().update(user);}
    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);}

    @Override
    public User get(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }




    @Override
    public List<User> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }


}
