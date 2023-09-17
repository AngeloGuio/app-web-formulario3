package pe.edu.cibertec.appwebformulario3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pe.edu.cibertec.appwebformulario3.model.PromedioModel;


@Controller
public class FormimcController {

    @GetMapping("/promedionotas")
    public String index(Model model){
        model.addAttribute("promediomodel",
                new PromedioModel());
        model.addAttribute("verresultado",
                false);
        return "formpromedio";
    }
    @PostMapping("/promedionotas")
    public String calcularpromedio(
            @ModelAttribute("promediomodel")
            PromedioModel promedioModel,
            Model model
    ){
        Double promedio = (promedioModel.getCl1()*0.15)+
                (promedioModel.getCl2()*0.2)+
                (promedioModel.getCl3()*0.35)+
                (promedioModel.getProfin()*0.3);

        String condicion = (promedio > 10.05) ? "Aprobado" : "Desaprobado";
        model.addAttribute("resultado",
                "El promedio de nota es : "
                +promedio+ "usted se encuentra: "+ condicion);
        model.addAttribute("verresultado",
                true);
        model.addAttribute("promediomodel",
                new PromedioModel());
        return "formpromedio";
    }



}
