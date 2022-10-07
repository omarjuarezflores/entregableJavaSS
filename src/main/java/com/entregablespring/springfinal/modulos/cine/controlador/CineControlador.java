package com.entregablespring.springfinal.modulos.cine.controlador;

import com.entregablespring.springfinal.modelos.Cine;
import com.entregablespring.springfinal.modulos.cine.dto.CineDTO;
import com.entregablespring.springfinal.modulos.cine.servicio.CineServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cine")
public class CineControlador {

    @Autowired
    private CineServicio cineServicio;

    @GetMapping("obtener")
    public ResponseEntity<List<CineDTO>> obtenerCine(){
        List<CineDTO> lista = cineServicio.obtenerCine();
        return new ResponseEntity<>( lista, HttpStatus.OK);
    }

    @GetMapping("obtener/")
    public ResponseEntity<CineDTO> obtenerCineById(@RequestParam Integer idCine){
        CineDTO respuesta = cineServicio.obtenerCineById(idCine);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

    @PostMapping("guardar")
    public ResponseEntity<Boolean> guardarCine(@RequestBody CineDTO paramentros){
        boolean respuesta = cineServicio.guardarCine(paramentros);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

    @PutMapping ("update")
    public ResponseEntity<Boolean> updateCine(@RequestBody CineDTO parametros){
        boolean respuesta = cineServicio.updateCine(parametros);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Boolean> deleteCine(@RequestParam Integer idCine){
        boolean respuesta = cineServicio.deleteCine(idCine);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }


    @PutMapping ("activar-inactivar")
    public ResponseEntity<String> activarInactivar(@RequestParam Integer idCine){
        String respuesta = cineServicio.activarInactivar(idCine);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

    @GetMapping("obtener/cines/por-sala")
    public ResponseEntity<List<CineDTO>> obtenerCinesPorSala(@RequestParam Integer idSala){
        List<CineDTO> respuesta = cineServicio.obtenerCinesPorSala(idSala);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
