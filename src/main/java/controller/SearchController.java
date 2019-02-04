package controller;

import entity.Item;
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
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }


    @GetMapping
    public ModelAndView searchPage(HttpServletRequest request, HttpServletResponse response, @RequestParam String name) {
        ModelAndView model = new ModelAndView("search");
        Collection<Item> items = searchService.getSomeItems(name);
        model.addObject("items", items);
        return model;
    }


}