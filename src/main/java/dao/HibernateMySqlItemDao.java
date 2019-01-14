package dao;

import entity.Item;
import hibernate.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class HibernateMySqlItemDao implements ItemDao {
    @Override
    public List<Item> get() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<Item> out = s.createCriteria(Item.class).list();
        s.close();
        return out;
    }

    public void save(Item i) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(i);
        s.getTransaction().commit();
        s.close();
    }

    // HQL query for getById(String id) is "FROM Item WHERE id='"+id+"'"
    // with 'uniqueResult()' method usage
}
