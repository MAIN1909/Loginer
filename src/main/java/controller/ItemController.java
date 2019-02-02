package controller;

import entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ItService;


@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private final ItService itService;

    public ItemController(ItService itService) {
        this.itService = itService;
    }

    @GetMapping
    public ModelAndView item(@RequestParam String id) {

        ModelAndView model = new ModelAndView("item");
        Item items = itService.getById(id);
        model.addObject("items", items);
        return model;
    }
}

