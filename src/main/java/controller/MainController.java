package controller;

import entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.MainService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Controller
@RequestMapping("/main")
public class MainController {

    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping
    public ModelAndView mainPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("login") != null) {
            ModelAndView model = new ModelAndView("main");
            Collection<Item> items = mainService.getAllItems();
            model.addObject("items", items);
            return model;
        } else {
            response.sendRedirect("/loginer/");
            return null;
        }
    }
}
