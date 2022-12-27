package com.educandoweb.cursomc2022.resources;

import com.educandoweb.cursomc2022.entities.Estado;
import com.educandoweb.cursomc2022.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/Estados")
public class EstadoResource {

    @Autowired
    private EstadoService service;

    @GetMapping
    public ResponseEntity<List<Estado>> findAll() {
        List<Estado> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Estado> findById(@PathVariable Long id) {
        Estado obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
