package com.example.BODEGASTCCAPI.servicios;


import com.example.BODEGASTCCAPI.helpers.mensajes.Mensaje;
import com.example.BODEGASTCCAPI.helpers.validaciones.RemitenteValidacion;
import com.example.BODEGASTCCAPI.modelos.Remitente;
import com.example.BODEGASTCCAPI.repositorios.IRemitenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RemitenteServicio {

    //los servicios contienen metodos asociados
    //a alguna operacion en la base de datos
    //generalmente estas asociados a uno o mas
    //repositorios

    //Inyectar una dependencia al repositorio
    @Autowired
    IRemitenteRepositorio repositorio;

    @Autowired
    RemitenteValidacion validacion;

    //guardar
    public Remitente almacenarRemitente (Remitente datosRemitente) throws Exception{
        try {
            //aplicar validaciones a los datos recibidos
            //si sale bien la validacion llamo al repo para guardar los datos

            if (!this.validacion.validarNombre(datosRemitente.getNombres())) {
                throw new Exception(Mensaje.NOMBRE_INVALIDO.getMensaje());
            }

            if (!this.validacion.validarMunicipio(datosRemitente.getMunicipio())) {
                throw new Exception(Mensaje.MUNICIPIO_INVALIDA.getMensaje());
            }

            if (!this.validacion.validarDepartamento(datosRemitente.getDepartamento())) {
                throw new Exception(Mensaje.DEPARTAMENTO_INVALIDO.getMensaje());
            }

           return this.repositorio.save(datosRemitente);
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }


}
