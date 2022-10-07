package com.entregablespring.springfinal.repositorios;

import com.entregablespring.springfinal.modelos.Cine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CineRepositorio extends JpaRepository<Cine,Integer> {

    @Query("select e from Cine as e where e.registro_activo = true")
    List<Cine> findAll();
    @Query("select e from Cine e where e.sala = :idSala and e.registro_activo = true")
    List<Cine> obtenerCinesPorSala(@Param("idSala") Integer idSala);
}
