package com.entregablespring.springfinal.repositorios;

import com.entregablespring.springfinal.modelos.Cine;
import com.entregablespring.springfinal.modelos.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaRepositorio extends JpaRepository<Sala,Integer> {
    @Query("select e from Sala e where e.cine = :idCine and e.registro_activo = true")
    List<Sala> obtenerSalasPorCine(@Param("idCine") Integer idCine);
}
