package com.example.BODEGASTCCAPI.servicios;

import com.example.BODEGASTCCAPI.helpers.mensajes.Mensaje;
import com.example.BODEGASTCCAPI.helpers.validaciones.ZonaBodegaValidacion;
import com.example.BODEGASTCCAPI.modelos.ZonaBodega;
import com.example.BODEGASTCCAPI.repositorios.IZonaBodegaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZonaBodegaServicio {
    @Autowired
    IZonaBodegaRepositorio repositorio;

    @Autowired
    ZonaBodegaValidacion validacion;

    //guardar
    public ZonaBodega guardarZonaBodega(ZonaBodega datosZonaBodega) throws Exception{
        try{
            if(!this.validacion.validarNombreZona(datosZonaBodega.getNombreZona())){
                throw new Exception(Mensaje.NOMBRE_INVALIDO.getMensaje());
            }

            if(!this.validacion.validarcapacidadMaximaPeso(datosZonaBodega.getCapacidadMaximaPeso())){
                throw new Exception(Mensaje.CAPACIDAD_PESO.getMensaje());

            }

            if(!this.validacion.validarcapacidadMaximaVolumen(datosZonaBodega.getCapacidadMaximaVolumen())){
                throw new Exception(Mensaje.CAPACIDAD_VOLUMEN.getMensaje());
            }

            if(!this.validacion.validarcapacidadVolumenOcupado(datosZonaBodega.getCapacidadVolumenOcupado(), datosZonaBodega.getCapacidadMaximaVolumen())){
                throw new Exception(Mensaje.CAPACIDAD_VOLUMEN_OCUPADO.getMensaje());

            }

            if(!this.validacion.validarcapacidadPesoOcupado(datosZonaBodega.getCapacidadPesoOcupado(),datosZonaBodega.getCapacidadMaximaPeso())){
                throw new Exception(Mensaje.CAPACIDAD_PESO_OCUPADO.getMensaje());
            }

            return this.repositorio.save(datosZonaBodega);

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //buscar todos
    public List<ZonaBodega> buscarTodasZonaBodega(){
        return null;
    }

    //buscar por id
    public ZonaBodega buscarZonaBodegaPorId(Integer idZonaBodega){
        return null;
    }

    //buscar nombre
    public ZonaBodega buscarZonaBodegaPorNombre(String nombreZonaBodega){
        return null;
    }

    //modificar
    public ZonaBodega modificarZonaBodega(Integer idZonaBodega, ZonaBodega datosZonaBodega){
        return null;
    }

    //eliminar
    public boolean eliminarZonaBodega(Integer idZonaBodega){
        return true;
    }


}