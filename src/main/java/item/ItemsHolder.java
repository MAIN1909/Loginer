package item;

import dao.FileSystemItemDao;
import dao.MySqlItemDao;
import entity.Item;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ItemsHolder {
    public static final Map<UUID, Item> items;

    static {
        items = new ConcurrentHashMap<>();
        for (Item i : new MySqlItemDao().get()) {
//            Для доступа из файлов
//        for (Item i : new FileSystemItemDao().get()) {
            items.put(i.getId(), i);
        }
    }
}
