package entity;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "loginer_item")
public class Item {
    @Id
    @Type(type = "uuid-char")
    private UUID id;
    private String name;
    private String description;
    private int price;
    private String pic;

    public Item() {
    }

    public Item(UUID id, String name, String description, int price, String pic) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.pic = pic;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return price == item.price &&
                Objects.equals(id, item.id) &&
                Objects.equals(name, item.name) &&
                Objects.equals(description, item.description) &&
                Objects.equals(pic, item.pic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, pic);
    }
}
