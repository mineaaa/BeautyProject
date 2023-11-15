package hh.sof03.harjoitustyo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof03.harjoitustyo.domain.KategoriaRepository;
import hh.sof03.harjoitustyo.domain.Kynsilakka;
import hh.sof03.harjoitustyo.domain.KynsilakkaRepository;
import jakarta.validation.Valid;

@Controller
public class KynsilakkaController {

    @Autowired
    KynsilakkaRepository kynsilakkaRepository;

    @Autowired
    KategoriaRepository kategoriaRepository;

    @RequestMapping(value = "/kynsilakkalist", method = RequestMethod.GET)
    public String listAllNailpolish(Model model) {
        model.addAttribute("kynsilakat", kynsilakkaRepository.findAll());
        return "kynsilakkalist";
    }

    @RequestMapping(value = "/deletenailpolish/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteNailPolish(@PathVariable("id") Long id, Model model) {
        kynsilakkaRepository.deleteById(id);
        return "redirect:../kynsilakkalist";
    }

    @RequestMapping(value = "/addnailpolish", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addNailPolsih(Model model) {
        model.addAttribute("kynsilakka", new Kynsilakka());
        model.addAttribute("kategoriat", kategoriaRepository.findAll());
        return "addkynsilakka";
    }

    @RequestMapping(value = "/savenailpolish", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveNailpolish(@Valid Kynsilakka kynsilakka, BindingResult bindingResult, Model model) {
        model.addAttribute("kategoriat", kategoriaRepository.findAll());
        if (bindingResult.hasErrors()) {
            return "addkynsilakka";
        }
        kynsilakkaRepository.save(kynsilakka);
        return "redirect:/kynsilakkalist";
    }

    @RequestMapping(value = "/editnailpolish/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editNailPolish(@PathVariable("id") Long id, Model model) {
        model.addAttribute("nailpolish", kynsilakkaRepository.findById(id));
        model.addAttribute("kategoriat", kategoriaRepository.findAll());
        return "editkynsilakka";
    }

    @RequestMapping(value = "/saveeditnailpolish", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editKynsilakkaSubmit(@Valid @ModelAttribute("nailpolish") Kynsilakka nailpolish,
            BindingResult bindingResult, Model model) {
        model.addAttribute("kategoriat", kategoriaRepository.findAll());
        if (bindingResult.hasErrors()) {
            return "editkynsilakka";
        }
        kynsilakkaRepository.save(nailpolish);
        return "redirect:/kynsilakkalist";
    }

    @RequestMapping(value = "/rest/kynsilakka/getVäri", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public @ResponseBody List<Kynsilakka> getVäri(@RequestParam("lakkaVari") String lakkaVari) {
        return kynsilakkaRepository.findByLakkaVari(lakkaVari);
    }

}
