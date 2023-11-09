package hh.sof03.harjoitustyo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof03.harjoitustyo.domain.Kategoria;
import hh.sof03.harjoitustyo.domain.KategoriaRepository;

@Controller
public class KategoriaController {

    @Autowired
    KategoriaRepository kategoriaRepository;

    @RequestMapping(value = "/kategorialist", method = RequestMethod.GET)
    public String listAllCategories(Model model) {
        model.addAttribute("kategoriat", kategoriaRepository.findAll());
        return "kategorialist";
    }

    @RequestMapping(value = "/addtype", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addProductType(Model model) {
        model.addAttribute("kategoria", new Kategoria(null));
        return "addkategoria";
    }

    @RequestMapping(value = "/savetype", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveProductType(Kategoria kategoria) {
        kategoriaRepository.save(kategoria);
        return "redirect:/kategorialist";
    }

    @RequestMapping(value = "/deletecategory/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteCategory(@PathVariable("id") Long id, Model model) {
        kategoriaRepository.deleteById(id);
        return "redirect:/kategorialist";
    }

    @RequestMapping(value = "/editcategory/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editCategory(@PathVariable("id") Long id, Model model) {
        model.addAttribute("kategoria", kategoriaRepository.findById(id));
        return "editkategoria";
    }

    @RequestMapping(value = "/saveeditcategory", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveEditCategory(@ModelAttribute("kategoria") Kategoria kategoria) {
        kategoriaRepository.save(kategoria);
        return "redirect:/kategorialist";
    }

    @RequestMapping(value = "/rest/kategoria/getCategory", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public @ResponseBody List<Kategoria> getCategory(@RequestParam("tuotetyyppi") String tuotetyyppi) {
        return kategoriaRepository.findByTuotetyyppi(tuotetyyppi);
    }
}
