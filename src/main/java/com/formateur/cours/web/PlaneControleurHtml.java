package com.formateur.cours.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.formateur.correctionformateur.model.Plane;
import com.formateur.correctionformateur.service.PlaneService;

@Controller
public class PlaneControleurHtml {

    @Autowired
    private PlaneService planeService;

    @ModelAttribute("planes")
    public Iterable<Plane> getPlanes() {
        return this.planeService.findAll();
    }

    @RequestMapping(path = "/planes", method = RequestMethod.GET)
    public String getVueSalut() {
        return "vue-planes";
    }

    @RequestMapping(path = "/planes/{id}", method = RequestMethod.GET)
    public ModelAndView getVueAvecModel(@PathVariable("id") Long planeId) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("vue-plane");
        mav.addObject("plane", planeService.findById(planeId).orElseGet(Plane::new));
        return mav;
    }

    @PostMapping("/planes")
    public ModelAndView processSubmit(@Validated @ModelAttribute("plane") Plane plane,
            BindingResult result) {
        ModelAndView mav = new ModelAndView("vue-plane");
        mav.addObject("plane", plane);
        if (result.hasErrors()) {
            return mav;
        }
        if (plane != null && plane.getId() != null) {
            mav.setViewName("redirect:/planes/" + plane.getId());
        }
        // else
        this.planeService.save(plane);
        System.out.println("L'avion : " + plane + " a été sauvegardé");
        return mav;
    }
}
