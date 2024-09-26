package com.example.BODEGASTCCAPI.helpers.validaciones;

import org.springframework.stereotype.Component;


@Component
public class ZonaBodegaValidacion {

    public boolean validarNombreZona(String nombreZona){
        if(nombreZona.length()>30){
            return false;
        }
        return nombreZona.matches("^[a-zA-Z\\s]+$");
    }

    public boolean validarcapacidadMaximaVolumen(Double volumen){
        return volumen > 0 && volumen < 500;
    }

    public boolean validarcapacidadMaximaPeso(Double peso){
        return peso > 0 && peso < 100;
    }

    public boolean validarcapacidadVolumenOcupado(Double volumenOcupado, Double volumen){
        return volumenOcupado < volumen;
    }

    public boolean validarcapacidadPesoOcupado(Double pesoOcupado, Double peso){
        return pesoOcupado < peso ;
    }

}