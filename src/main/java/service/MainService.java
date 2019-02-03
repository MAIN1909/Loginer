package service;

import entity.Item;
import item.ItemsHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MainService {
    public Collection<Item> getAllItems() {
        return ItemsHolder.items.values();
    }
}
