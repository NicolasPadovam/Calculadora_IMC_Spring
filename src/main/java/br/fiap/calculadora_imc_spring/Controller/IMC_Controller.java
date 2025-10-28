package br.fiap.calculadora_imc_spring.Controller;

import br.fiap.calculadora_imc_spring.Service.IMC_Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class IMC_Controller {
    private final IMC_Service service;

    public IMC_Controller(IMC_Service service) {
        this.service = service;
    }

    @PostMapping("/calcular")
    public String calcular(@RequestParam String altura, @RequestParam String peso, Model model){

        BigDecimal resultado =  null;
        String erro = "";

        try {
            resultado  = service.calcular(altura,peso);
        } catch (Exception e){
            erro = e.getMessage();
        }

        model.addAttribute("resultado", resultado);
        model.addAttribute("erro", erro);
        model.addAttribute("altura", altura);
        model.addAttribute("peso",peso);

        return "index";

    }
}
