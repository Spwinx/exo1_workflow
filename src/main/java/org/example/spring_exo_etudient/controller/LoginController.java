package org.example.spring_exo_etudient.controller;

import org.example.spring_exo_etudient.service.EtudientJpaService;
import org.example.spring_exo_etudient.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class  LoginController {

    private final LoginService loginService;
    private final EtudientJpaService etudientService;

    @Autowired
    public LoginController(LoginService loginService, EtudientJpaService etudientService) {
        this.loginService = loginService;
        this.etudientService = etudientService;
    }

    @RequestMapping("/login")
    public String loginForm() {
        return "formlogin";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        if (loginService.login(username, password)) {
            model.addAttribute("EtudientsNom", etudientService.findAll());
            return "index";
        }
        return "redirect:/login";
    }

    @RequestMapping("/logout")
    public String logout() {
        loginService.logout();
        return "redirect:/login";
    }

}
