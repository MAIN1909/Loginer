package controller;


import entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.SearchService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;


@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private final SearchService mainService;

    public SearchController(SearchService mainService) {
        this.mainService = mainService;
    }


    @GetMapping
    public ModelAndView search(HttpServletRequest request, HttpServletResponse response, @RequestParam String name) {

        ModelAndView model = new ModelAndView("main");
        Collection<Item> items = mainService.getItems(name);
        model.addObject("items", items);
        return model;
    }

}
