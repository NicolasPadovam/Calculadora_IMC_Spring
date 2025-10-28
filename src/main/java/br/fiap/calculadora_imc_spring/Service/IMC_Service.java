package br.fiap.calculadora_imc_spring.Service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Service
public class IMC_Service {

    public BigDecimal calcular(String altura, String peso){
        BigDecimal alt = toBigDecimal(altura);
        BigDecimal pes = toBigDecimal(peso);

        return pes.divide((alt.multiply(alt)),2, RoundingMode.HALF_UP);
    }


    private BigDecimal toBigDecimal(String valor){
        String aux = valor.trim().replace(",",".");

        try {
            return new BigDecimal(aux);
        } catch (Exception e){
            throw new IllegalArgumentException("Voce deve informar apenas numeros");
        }
    }
}
