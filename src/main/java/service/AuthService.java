package service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public boolean isAuthenticated(String login) {
        return "admin".equals(login);
    }
}
