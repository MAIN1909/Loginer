package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.AuthService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public ModelAndView authPage() {
        return new ModelAndView("auth");
    }

    @PostMapping
    public void authenticate(HttpServletRequest request,
                             HttpServletResponse response,
                             @RequestParam String login) throws IOException {
        if (authService.isAuthenticated(login)) {
            request.getSession().setAttribute("login", login);
            response.sendRedirect("/loginer/main");
        } else {
            response.sendRedirect("/loginer/");
        }
    }

}
