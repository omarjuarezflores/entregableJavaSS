package com.entregablespring.springfinal.modulos.cine.controlador;

import com.entregablespring.springfinal.modulos.cine.dto.SalaDTO;
import com.entregablespring.springfinal.modulos.cine.servicio.SalaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sala")
public class SalaControlador {
    @Autowired
    private SalaServicio salaServicio;

    @GetMapping("obtener")
    public ResponseEntity<List<SalaDTO>> obtenerSala(){
        List<SalaDTO> lista = salaServicio.obtenerSala();
        return new ResponseEntity<>( lista, HttpStatus.OK);
    }

    @GetMapping("obtener/id")
    public ResponseEntity<SalaDTO> obtenerSalaById(@RequestParam Integer idSala){
        SalaDTO respuesta = salaServicio.obtenerSalaById(idSala);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

    @PostMapping("guardar")
    public ResponseEntity<Boolean> guardarSala(@RequestBody SalaDTO paramentros){
        boolean respuesta = salaServicio.guardarSala(paramentros);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

    @PutMapping ("update")
    public ResponseEntity<Boolean> updateSala(@RequestBody SalaDTO parametros){
        boolean respuesta = salaServicio.updateSala(parametros);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Boolean> deleteSala(@RequestParam Integer idSala){
        boolean respuesta = salaServicio.deleteSala(idSala);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }


    @PutMapping ("activar-inactivar")
    public ResponseEntity<String> activarInactivar(@RequestParam Integer idSala){
        String respuesta = salaServicio.activarInactivar(idSala);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }
  
}
