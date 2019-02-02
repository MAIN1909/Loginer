package service;


import org.springframework.stereotype.Service;


@Service
public class AddService {
    public boolean isAuthenticated(String name, String description, String price, String pic) {
        return !name.equals(null) && !description.equals(null) && !price.equals(null) && !pic.equals(null);
    }


}
