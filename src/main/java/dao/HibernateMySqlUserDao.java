package dao;

import entity.User;
import hibernate.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class HibernateMySqlUserDao implements UserDao {
    @Override
    public List<User> get() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<User> out = s.createQuery("FROM User").list();
        s.close();
        return out;
    }

    @Override
    public void save(User user) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(user);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public List<User> getByLogin(String login) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<User> out = s.createQuery("FROM User WHERE login LIKE'" + login + "'").list();
        s.close();
        return out;
    }
}
