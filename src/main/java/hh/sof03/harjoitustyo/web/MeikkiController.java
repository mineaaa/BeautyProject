package hh.sof03.harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.harjoitustyo.domain.KategoriaRepository;
import hh.sof03.harjoitustyo.domain.Meikki;
import hh.sof03.harjoitustyo.domain.MeikkiRepository;

@Controller
public class MeikkiController {

    @Autowired
    MeikkiRepository meikkiRepository;

    @Autowired
    KategoriaRepository kategoriaRepository;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String indexPage() {

        return "index";

    }

    @RequestMapping(value = "/meikkilist", method = RequestMethod.GET)
    public String listAllMakeup(Model model) {
        model.addAttribute("makeups", meikkiRepository.findAll());
        return "meikkilist";
    }

    @RequestMapping(value = "/deletemakeup/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteMakeup(@PathVariable("id") Long id, Model model) {
        meikkiRepository.deleteById(id);
        return "redirect:../meikkilist";
    }

    @RequestMapping(value = "/addmakeup", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addMakeup(Model model) {
        model.addAttribute("meikki", new Meikki());
        model.addAttribute("kategoriat", kategoriaRepository.findAll());
        return "addmakeup";
    }

    @RequestMapping(value = "/savemakeup", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveMakeup(Meikki meikki) {
        meikkiRepository.save(meikki);
        return "redirect:/meikkilist";
    }

    @RequestMapping(value = "/editmakeup/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editMeikki(@PathVariable("id") Long id, Model model) {
        model.addAttribute("makeup", meikkiRepository.findById(id));
        model.addAttribute("kategoriat", kategoriaRepository.findAll());
        return "editmeikki";
    }

    @RequestMapping(value = "/saveeditmeikki", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editMeikkiSubmit(@ModelAttribute("makeup") Meikki makeup) {
        meikkiRepository.save(makeup);
        return "redirect:/meikkilist";
    }

}
