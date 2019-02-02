package controller;

import dao.ItemDao;
import entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.AddService;
import spring.SpringContextHolder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/add")
public class AddController {
    private final AddService addService;

    @Autowired
    public AddController(AddService addService) {
        this.addService = addService;
    }

    @GetMapping
    public ModelAndView mainPage() {

        ModelAndView model = new ModelAndView("add");
        return model;
    }

    @PostMapping
    public void authenticate(HttpServletResponse response,
                             @RequestParam String name, String description, String price, String pic) throws IOException {
        if (addService.isAuthenticated(name, description, String.valueOf(Integer.parseInt(price)), pic)) {
            response.sendRedirect("/loginer/main");
        }
        ((ItemDao) SpringContextHolder.getContext().getBean("idao")).save(new Item(UUID.randomUUID(), name, description, Integer.parseInt(price), pic));


    }
}
