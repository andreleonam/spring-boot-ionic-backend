package com.educandoweb.cursomc2022.resources;

import com.educandoweb.cursomc2022.entities.Cidade;
import com.educandoweb.cursomc2022.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {

    @Autowired
    private CidadeService service;

    @GetMapping
    public ResponseEntity<List<Cidade>> findAll() {
        List<Cidade> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cidade> findById(@PathVariable Long id) {
        Cidade obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
