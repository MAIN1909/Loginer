package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.RegisterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping
    public ModelAndView registerPage() {
        return new ModelAndView("register");
    }

    @PostMapping
    public void registration(HttpServletRequest request,
                             HttpServletResponse response,
                             @RequestParam String login,
                             @RequestParam String pass,
                             @RequestParam String passConfirm) throws IOException {
        if (registerService.correctInput(login, pass, passConfirm)) {
            if (registerService.loginExtends(login)) {
//            System.out.println("User is exist  "+((HibernateMySqlUserDao) SpringContextHolder.getContext().getBean("user_dao")).getByLogin(login));
                response.sendRedirect("/loginer/register");
            } else {
                registerService.userRegistration(login, pass);
                response.sendRedirect("/loginer");
            }
        } else {
//        System.out.println("Something is not filled");
            response.sendRedirect("/loginer/register");
        }
    }
}
