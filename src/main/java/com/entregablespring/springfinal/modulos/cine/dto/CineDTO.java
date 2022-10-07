package com.entregablespring.springfinal.modulos.cine.dto;

import com.entregablespring.springfinal.modelos.Cine;
import com.entregablespring.springfinal.modelos.Sala;
import com.entregablespring.springfinal.modulos.cine.servicio.CineServicio;

import java.sql.Time;
import java.sql.Timestamp;

public class CineDTO {

    private Integer cineID;
    private String cine;
    private Timestamp fecha_alta;
    private Timestamp fecha_modificacion;
    private Boolean registro_activo;

    private SalaDTO sala;

    public CineDTO(){super();}

    public CineDTO(Integer cineID, String cine, Timestamp fecha_alta, Timestamp fecha_modificacion, Boolean registro_activo) {
        this.cineID = cineID;
        this.cine = cine;
        this.fecha_alta = fecha_alta;
        this.fecha_modificacion = fecha_modificacion;
        this.registro_activo = registro_activo;

    }

    public CineDTO(Integer cineID, String cine, Timestamp fecha_alta, Timestamp fecha_modificacion, Boolean registro_activo, Integer idSala, Short numSala, Integer asientos, Timestamp fecha_alta_sala, Timestamp fecha_modificacion_sala, Boolean registro_activo_sala  ) {
        this.cineID = cineID;
        this.cine = cine;
        this.fecha_alta = fecha_alta;
        this.fecha_modificacion = fecha_modificacion;
        this.registro_activo = registro_activo;
        this.sala = new SalaDTO(idSala,numSala,asientos,fecha_alta_sala,fecha_modificacion_sala,registro_activo_sala);
    }

    public CineDTO (Cine c) {
        this.cineID = c.getId_cine();
        this.cine = c.getNombre();
        this.fecha_alta = c.getFecha_alta();
        this.fecha_modificacion = c.getFecha_modificacion();
        this.registro_activo = c.getRegistro_activo();
        this.sala = new SalaDTO(sala.getSalaID(), sala.getNum_sala(), sala.getAsientos(), sala.getFecha_alta(),sala.getFecha_modificacion(),sala.getRegistro_activo());
    }

    public Integer getCineID() {return cineID;}

    public void setCineID(Integer cineID) {this.cineID = cineID;}

    public String getCine() {return cine;}

    public void setCine(String cine) {this.cine = cine;}

    public Timestamp getFecha_alta() {return fecha_alta;}

    public void setFecha_alta(Timestamp fecha_alta) {this.fecha_alta = fecha_alta;}

    public Timestamp getFecha_modificacion() {return fecha_modificacion;}

    public void setFecha_modificacion(Timestamp fecha_modificacion) {this.fecha_modificacion = fecha_modificacion;}

    public Boolean getRegistro_activo() {return registro_activo;}

    public void setRegistro_activo(Boolean registro_activo) {this.registro_activo = registro_activo;}

    public SalaDTO getSala() {return sala;}

    public void setSala(SalaDTO sala) {this.sala = sala;}
}
