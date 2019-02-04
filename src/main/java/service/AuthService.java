package service;

import dao.HibernateMySqlUserDao;
import org.springframework.stereotype.Service;
import spring.SpringContextHolder;

@Service
public class AuthService {
    public boolean isAuthenticated(String login, String pass) {
        if (login != null && (((HibernateMySqlUserDao) SpringContextHolder.getContext().getBean("user_dao")).getByLogin(login).size() != 0)) {
            return pass.equals(((HibernateMySqlUserDao) SpringContextHolder.getContext().getBean("user_dao")).getByLogin(login).get(0).getPassword());
        } else {
            return false;
        }
    }
}
