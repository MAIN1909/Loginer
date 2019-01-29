package dao;

import entity.Item;

import java.util.List;

public interface ItemDao {
    List<Item> get();

    Item getById(String id);

    void save(Item item);

    List<Item> getByName(String name);
}
