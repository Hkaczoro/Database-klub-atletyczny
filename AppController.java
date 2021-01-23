package Example.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class AppController {

    @Autowired
    private Kategorie_wiekoweDAO dao;

    @RequestMapping("/Test/templates/index")
    public String viewHomePage(Model model) {
        List<Kategorie_wiekowe> listKatwiek = dao.list();
        model.addAttribute("listKatwiek",listKatwiek);
        return "index";
    }
/*
    @RequestMapping("/new_form")
    public String showNewForm(Model model) {
        Kategorie_wiekowe kategorie_wiekowe= new Kategorie_wiekowe();
        model.addAttribute("kategorie_wiekowe",kategorie_wiekowe);
        return "new_form";
    }*/



}
