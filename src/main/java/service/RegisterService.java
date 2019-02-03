package service;

import dao.HibernateMySqlUserDao;
import entity.User;
import org.springframework.stereotype.Service;
import spring.SpringContextHolder;

import java.util.UUID;

@Service
public class RegisterService {

    public boolean correctInput(String login, String pass, String passConfirm) {
//        System.out.println("login__ " + login + " pass__ "+pass+" conf__ "+passConfirm);
        return (!"".equals(login) && !"".equals(pass) && !"".equals(passConfirm) && login != null && pass != null && passConfirm != null && pass.equals(passConfirm));
    }

    public boolean loginExtends(String login) {
        return (((HibernateMySqlUserDao) SpringContextHolder.getContext().getBean("user_dao")).getByLogin(login).size() != 0);
    }

    public void userRegistration(String login, String pass) {
        User u = new User();
        UUID uuid = UUID.randomUUID();
        u.setId(uuid);
        u.setLogin(login);
        u.setPassword(pass);
        ((HibernateMySqlUserDao) SpringContextHolder.getContext().getBean("user_dao")).save(u);
//        System.out.println("User added   "+ u);
    }

}
