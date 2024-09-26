package com.example.BODEGASTCCAPI.helpers.validaciones;


import org.springframework.stereotype.Component;

@Component
public class RemitenteValidacion {

    public boolean validarNombre (String nombre){
        if (nombre.length()>60){
            return false;
        }
        return nombre.matches("^[a-zA-Z\\s]+$"); //Mayusculas, minusculas y espacios en blanco
    }

    public boolean validarDepartamento (String departamento){

        // Verificar si el nombre es nulo
        if (departamento == null) {
            return false;
        }

        // Verificar si la longitud del nombre es mayor a 60 caracteres
        if (departamento.length() > 60) {
            return false;
        }

        return departamento.matches("^[a-zA-Z]+$");

    }

    public boolean validarMunicipio (String municipio){

        // Verificar si el nombre es nulo
        if (municipio == null) {
            return false;
        }

        // Verificar si la longitud del nombre es mayor a 60 caracteres
        if (municipio.length() > 60) {
            return false;
        }

        return municipio.matches("^[a-zA-Z]+$");

    }


}
