package item;

import dao.ItemDao;
import entity.Item;
import spring.SpringContextHolder;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ItemsHolder {
    public static final Map<UUID, Item> items;

    static {
        items = new ConcurrentHashMap<>();
//        Для доступа из MySql
//        for (Item i : new MySqlItemDao().get()) {
//            Для доступа из файлов
//        for (Item i : new FileSystemItemDao().get()) {
//            Для доступа из Hibernate
        for (Item i : ((ItemDao) SpringContextHolder.getContext().getBean("idao")).get()) {
            items.put(i.getId(), i);
        }
    }
}
