package item;

import entity.Item;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ItemsHolder {
    public static final Map<UUID, Item> items;

    static {
        items = new ConcurrentHashMap<>();
        Item i1 = new Item(UUID.randomUUID(), "Freege", "Siemens big freege", 15000, "http://i.piccy.info/i9/6a402bdc033cc60d9d418abbdf3f1cb0/1544399078/161873/1287748/bmw.jpg");
        Item i2 = new Item(UUID.randomUUID(), "Plate", "Siemens small plate", 250, "http://i.piccy.info/i9/6a402bdc033cc60d9d418abbdf3f1cb0/1544399078/161873/1287748/bmw.jpg");
        items.put(i1.getId(), i1);
        items.put(i2.getId(), i2);
    }
}
