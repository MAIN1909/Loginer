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

import javax.servlet.http.HttpServletRequest;
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

    @PostMapping
    public ModelAndView addPage(HttpServletRequest request, HttpServletResponse response,
                                @RequestParam String name, String description, String price, String pic) throws IOException {

        ModelAndView model = new ModelAndView("add");
        if (addService.isName(name) && addService.isDescription(description) && addService.isPrice(price) && addService.isPicture(pic)) {
            response.sendRedirect("/loginer/main");
            ((ItemDao) SpringContextHolder.getContext().getBean("idao")).save(new Item(UUID.randomUUID(), name, description, Integer.parseInt(price), pic));
        }
        return model;

    }


    @GetMapping
    public ModelAndView authenticate() {
        return new ModelAndView("add");

    }


}