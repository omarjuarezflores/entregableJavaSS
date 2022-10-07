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
public class SalaServicio {

    @Autowired
    private SalaRepositorio salaRepositorio;
    @Autowired
    private CineRepositorio cineRepositorio;

    public List<SalaDTO> obtenerSala(){
        List<Sala> lista = salaRepositorio.findAll();
        //List<Empleado> lista2 = empleadoRepositorio.findByRegistro_activoIsTrue();
        List<SalaDTO> resultadoFinal = lista.stream().filter(s-> s.getRegistro_activo()==true).map(s -> {return new SalaDTO(s.getId_sala(), s.getNumero_sala() , s.getTotal_asientos(), s.getFecha_alta(), s.getFecha_modificacion(),s.getRegistro_activo()) ;}).collect(Collectors.toList());
        return resultadoFinal;
    }

    public SalaDTO obtenerSalaById(Integer idSala){
        Optional<Sala> sala = salaRepositorio.findById(idSala);
        if (sala.isPresent()){
            return new SalaDTO(sala.get().getId_sala(), sala.get().getNumero_sala(), sala.get().getTotal_asientos(),sala.get().getFecha_alta(), sala.get().getFecha_modificacion(), sala.get().getRegistro_activo());
        }
        return null;
    }

    public boolean guardarSala(SalaDTO parametros){
        Sala sala = new Sala();

        sala.setNumero_sala(parametros.getNum_sala());
        sala.setTotal_asientos(parametros.getAsientos());
        sala.setFecha_alta(parametros.getFecha_alta());
        sala.setFecha_modificacion(parametros.getFecha_modificacion());
        sala.setRegistro_activo(parametros.getRegistro_activo());

        salaRepositorio.save(sala);
        return true;
    }

    public boolean updateSala(SalaDTO parametros){

        Sala sala = salaRepositorio.getOne(parametros.getSalaID());
        sala.setNumero_sala(parametros.getNum_sala());
        sala.setTotal_asientos(parametros.getAsientos());
        sala.setFecha_alta(parametros.getFecha_alta());
        sala.setFecha_modificacion(parametros.getFecha_modificacion());
        sala.setRegistro_activo(parametros.getRegistro_activo());

        salaRepositorio.save(sala);
        return true;
    }

    public boolean deleteSala(Integer idSala){
        Sala sala = salaRepositorio.getOne(idSala);
        salaRepositorio.delete(sala);
        return true;
    }
    public String activarInactivar(Integer idSala){
        Sala sala = salaRepositorio.getOne(idSala);
        sala.setRegistro_activo(!sala.getRegistro_activo());
        salaRepositorio.save(sala);
        return "Eliminado con Exito";
    }
   
}
