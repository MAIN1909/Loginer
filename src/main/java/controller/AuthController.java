package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class AuthController {
    @GetMapping
    public ModelAndView authPage() {
        return new ModelAndView("auth");
    }

    @PostMapping
    public void authenticate(HttpServletRequest request,
                             HttpServletResponse response,
                             @RequestParam String login) throws IOException {
        if ("admin".equals(login)) {
            request.getSession().setAttribute("login", login);
            response.sendRedirect("/loginer/main");
        } else {
            response.sendRedirect("/loginer/");
        }
    }

}
