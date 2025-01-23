package com.formateur.cours.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginControllerHtml {

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String getVueLogin() {
        return "login";
    }

}
