package org.example.spring_exo_etudient.controller;

import jakarta.validation.Valid;
import org.example.spring_exo_etudient.entity.Etudient;
import org.example.spring_exo_etudient.service.EtudientJpaService;
import org.example.spring_exo_etudient.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class EtudientJpaController {
    private String location = "src/main/resources/static/images";

    private final EtudientJpaService etudientJpaService;
    private final LoginService loginService;


    @Autowired
    public EtudientJpaController(EtudientJpaService etudientJpaService, LoginService loginService) {
        this.etudientJpaService = etudientJpaService;
        this.loginService = loginService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }
        model.addAttribute("EtudientsNom", etudientJpaService.findAll());
        return "index";
    }

    @RequestMapping("/recherche")
    public String search(@RequestParam("prenom") String prenom, Model model) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }
        List<Etudient> resultatsRecherche = etudientJpaService.findByPrenom(prenom);
        model.addAttribute("EtudientsNom", resultatsRecherche);
        return "index";
    }

    @RequestMapping("/list-etudient")
    public String list(Model model) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }
        model.addAttribute("Etudients", etudientJpaService.findAll());
        return "list-etudient";
    }

    @RequestMapping("/etudient/{prenom}")
    public String etudient(@PathVariable String prenom, Model model) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }
        model.addAttribute("prenom", prenom);
        model.addAttribute("Etudients", etudientJpaService.findByPrenom(prenom));
        return "etudient";
    }


    @RequestMapping("/inscription")
    public String inscription(Model model) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }
        model.addAttribute("etudient", new Etudient());
        return "inscription";
    }

    @PostMapping("/inscription")
    public String inscription(
            @Valid @ModelAttribute("etudient") Etudient etudient,
            BindingResult bindingResult) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }

        if (bindingResult.hasErrors()) {
            return "inscription";
        } else {
            etudientJpaService.save(etudient);
            return "redirect:/";
        }
    }

    @RequestMapping("/Supprime/{id}")
    public String Supprime(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }
        etudientJpaService.delete(etudientJpaService.findById(id));
        return "explosion";
    }


    @RequestMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }
        Etudient etudient = etudientJpaService.findById(id);
        model.addAttribute("Etudient", etudient);
        return "update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("Etudient") Etudient etudient, BindingResult bindingResult) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }

        if (bindingResult.hasErrors()) {
            return "update";
        } else {
            etudientJpaService.save(etudient);
            return "redirect:/list-etudient";
        }
    }

    @PostMapping("/upload")
    public String postForm(@RequestParam("image") MultipartFile image, @RequestParam("prenom") String prenom) throws IOException {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }

        List<Etudient> etudiants = etudientJpaService.findByPrenom(prenom);

        Etudient etudient = etudiants.get(0);

        Path destinationFile = Paths.get(location).resolve(image.getOriginalFilename()).toAbsolutePath();
        InputStream inputStream = image.getInputStream();

        Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);

        etudient.setImage(image.getOriginalFilename());
        etudientJpaService.save(etudient);

        return "redirect:/etudient/" + prenom;
    }


}