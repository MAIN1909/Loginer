package dao;

import entity.Item;
import spring.SpringContextHolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class FileSystemItemDao implements ItemDao {
    @Override
    public List<Item> get() {
        File idf = (File) SpringContextHolder.getContext().getBean("id_file");
        File name = (File) SpringContextHolder.getContext().getBean("name_file");
        File desc = (File) SpringContextHolder.getContext().getBean("desc_file");
        File pic = (File) SpringContextHolder.getContext().getBean("pic_file");
        File price = (File) SpringContextHolder.getContext().getBean("price_file");
        List<Item> out = new LinkedList<>();

        try (BufferedReader brId = new BufferedReader(new FileReader(idf));
             BufferedReader brName = new BufferedReader(new FileReader(name));
             BufferedReader brDesc = new BufferedReader(new FileReader(desc));
             BufferedReader brPic = new BufferedReader(new FileReader(pic));
             BufferedReader brPrice = new BufferedReader(new FileReader(price))) {
            String strId;
            while ((strId = brId.readLine()) != null) {
                out.add(new Item(UUID.fromString(strId), brName.readLine(),
                        brDesc.readLine(), Integer.parseInt(brPrice.readLine()),
                        brPic.readLine()));
            }
            return out;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Item getById(String id) {
        File idf = (File) SpringContextHolder.getContext().getBean("id_file");
        File name = (File) SpringContextHolder.getContext().getBean("name_file");
        File desc = (File) SpringContextHolder.getContext().getBean("desc_file");
        File pic = (File) SpringContextHolder.getContext().getBean("pic_file");
        File price = (File) SpringContextHolder.getContext().getBean("price_file");

        try (BufferedReader brId = new BufferedReader(new FileReader(idf));
             BufferedReader brName = new BufferedReader(new FileReader(name));
             BufferedReader brDesc = new BufferedReader(new FileReader(desc));
             BufferedReader brPic = new BufferedReader(new FileReader(pic));
             BufferedReader brPrice = new BufferedReader(new FileReader(price))) {
            String strId;
            Item out = null;
            while ((strId = brId.readLine()).equals(id)) {
                out = new Item(UUID.fromString(strId), brName.readLine(),
                        brDesc.readLine(), Integer.parseInt(brPrice.readLine()),
                        brPic.readLine());
            }
            return out;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Item item) {

    }

    @Override
    public List<Item> getByName(String name) {
        return null;
    }
}
