package com.formateur.cours.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SalutControleurHtml {

    @ModelAttribute("dateEtHeureDuJour")
    public String getDateEtHeureDuJour() {
        return LocalDateTime.now().toString();
    }

    @RequestMapping(path = "/salut", method = RequestMethod.GET)
    public String getVueSalut() {
        return "vue-salut";
    }

}
