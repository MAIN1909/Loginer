package dao;

import entity.Item;
import service.ItemServise;

import java.util.List;

public interface ItemDao {
    List<Item> get();

    Item getById(String id);

    ItemServise save(Item item);

    List<Item> getByName(String name);
}
