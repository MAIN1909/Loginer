package service;

import dao.ItemDao;
import entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItService {
    private final ItemDao itemDao;

    @Autowired
    public ItService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }


    public Item getById(String id) {
        return itemDao.getById(id);
    }
}