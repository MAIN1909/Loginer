package service;

import dao.ItemDao;
import entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SearchService {
    private final ItemDao itemDao;

    @Autowired
    public SearchService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public Collection<Item> getSomeItems(String name) {
        return itemDao.getByName(name);
    }

}