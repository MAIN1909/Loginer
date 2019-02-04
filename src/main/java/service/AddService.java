package service;

import org.springframework.stereotype.Service;

@Service
public class AddService {

    public boolean isName(String name) {
        return !name.equals(null);
    }

    public boolean isDescription(String description) {
        return !description.equals(null);
    }

    public boolean isPrice(String price) {
        return !price.equals(null);
    }

    public boolean isPicture(String picture) {
        return !picture.equals(null);
    }


}