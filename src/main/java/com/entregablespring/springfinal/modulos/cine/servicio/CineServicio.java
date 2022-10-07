package com.entregablespring.springfinal.modulos.cine.servicio;

import com.entregablespring.springfinal.modelos.Cine;
import com.entregablespring.springfinal.modelos.Sala;
import com.entregablespring.springfinal.modulos.cine.dto.CineDTO;
import com.entregablespring.springfinal.modulos.cine.dto.SalaDTO;
import com.entregablespring.springfinal.repositorios.CineRepositorio;
import com.entregablespring.springfinal.repositorios.SalaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CineServicio {

    @Autowired
    private CineRepositorio cineRepositorio;

    @Autowired
    private SalaRepositorio salaRepositorio;

    public List<CineDTO> obtenerCine(){
        List<Cine> lista = cineRepositorio.findAll();
        //List<Empleado> lista2 = empleadoRepositorio.findByRegistro_activoIsTrue();
        List<CineDTO> resultadoFinal = lista.stream().filter(c-> c.getRegistro_activo()==true).map(c -> {return new CineDTO(c.getId_cine(), c.getNombre() , c.getFecha_alta(), c.getFecha_modificacion(), c.getRegistro_activo());}).collect(Collectors.toList());
        return resultadoFinal;
    }

    public CineDTO obtenerCineById(Integer idCine){
        Optional<Cine> cine = cineRepositorio.findById(idCine);
        if (cine.isPresent()){
            return new CineDTO(cine.get().getId_cine(), cine.get().getNombre(), cine.get().getFecha_alta(), cine.get().getFecha_modificacion(), cine.get().getRegistro_activo());
        }
        return null;
    }

    public boolean guardarCine(CineDTO parametros){
        Cine cine = new Cine();

        cine.setNombre(parametros.getCine());
        cine.setFecha_alta(parametros.getFecha_alta());
        cine.setFecha_modificacion(parametros.getFecha_modificacion());
        cine.setRegistro_activo(parametros.getRegistro_activo());

        cineRepositorio.save(cine);
        return true;
    }

    public boolean updateCine(CineDTO parametros){

        Cine cine = cineRepositorio.getOne(parametros.getCineID());
        cine.setNombre(parametros.getCine());
        cine.setFecha_alta(parametros.getFecha_alta());
        cine.setFecha_modificacion(parametros.getFecha_modificacion());
        cine.setRegistro_activo(parametros.getRegistro_activo());

        cineRepositorio.save(cine);
        return true;
    }

    public boolean deleteCine(Integer idCine){
        Cine cine = cineRepositorio.getOne(idCine);
        cineRepositorio.delete(cine);
        return true;
    }
    public String activarInactivar(Integer idCine){
       Cine cine = cineRepositorio.getOne(idCine);
       cine.setRegistro_activo(!cine.getRegistro_activo());
       cineRepositorio.save(cine);
       return "Eliminado con Exito";
    }

    public List<CineDTO> obtenerCinesPorSala(Integer idSala) {
        List<Cine> lista = cineRepositorio.obtenerCinesPorSala(idSala);
        return lista.stream().map(CineDTO::new).collect(Collectors.toList());
    }
}
