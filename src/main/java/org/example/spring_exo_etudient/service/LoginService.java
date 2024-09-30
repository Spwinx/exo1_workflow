package org.example.spring_exo_etudient.service;

import jakarta.servlet.http.HttpSession;
import org.example.spring_exo_etudient.dao.AdminRepository;
import org.example.spring_exo_etudient.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class LoginService {

    @Autowired
    private HttpSession httpSession;
    private final AdminRepository adminRepository;

    public LoginService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public boolean login(String username, String password) {
        Admin admin = adminRepository.findById(1).orElse(null);
        if (admin != null && username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
            httpSession.setAttribute("login", "OK");
            return true;
        }
        return false;
    }

    public boolean isLogged() {
        try {
            String isOK = httpSession.getAttribute("login").toString();
            return isOK.equals("OK");
        } catch (Exception e) {
            return false;
        }
    }

    public void logout() {
        httpSession.removeAttribute("login");
    }
}