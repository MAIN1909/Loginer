package dao;

import entity.Item;

import java.util.List;

public interface ItemDao {
    List<Item> get();

    Item getById(String id);
}
