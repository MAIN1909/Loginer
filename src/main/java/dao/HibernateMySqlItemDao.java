package dao;

import entity.Item;
import hibernate.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class HibernateMySqlItemDao implements ItemDao {
    @Override
    public List<Item> get() {
        Session s = HibernateUtil.getSessionFactory().openSession();
//        List<Item> out = s.createCriteria(Item.class).list();
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
}
