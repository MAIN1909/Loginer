package service;


import dao.ItemDao;
import entity.Item;
import org.springframework.stereotype.Service;
import spring.SpringContextHolder;

import java.util.Collection;

@Service
public class SearchService {

    public Collection<Item> getItems(String name) {
        return ((ItemDao) SpringContextHolder.getContext().getBean("idao")).getByName(name);
    }
}
