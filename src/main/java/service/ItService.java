package service;

import dao.ItemDao;
import entity.Item;
import org.springframework.stereotype.Service;
import spring.SpringContextHolder;

@Service
public class ItService {
    public Item getById(String id) {
        return ((ItemDao) SpringContextHolder.getContext().getBean("idao")).getById(id);
    }
}