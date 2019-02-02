package dao;

import entity.Item;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import service.ItemServise;

import java.util.List;

@Component
public class HibernateMySqlItemDao implements ItemDao {
    @Override
    public List<Item> get() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<Item> out = s.createQuery("FROM Item").list();
        s.close();
        return out;
    }

    @Override
    public Item getById(String id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Item out = (Item) s.createQuery("FROM Item WHERE id='" + id + "'").uniqueResult();
        s.close();
        return out;
    }

    public ItemServise save(Item i) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(i);
        s.getTransaction().commit();
        s.close();
        return null;
    }

    @Override
    public List<Item> getByName(String name) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<Item> out = s.createQuery("FROM Item WHERE name LIKE'%" + name + "%'").list();
        s.close();
        return out;
    }


}
