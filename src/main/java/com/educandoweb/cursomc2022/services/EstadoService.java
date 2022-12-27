package com.educandoweb.cursomc2022.services;

import com.educandoweb.cursomc2022.entities.Estado;
import com.educandoweb.cursomc2022.repositories.EstadoRepository;
import com.educandoweb.cursomc2022.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repository;

    public List<Estado> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public Estado findById(Long id) {
        Optional<Estado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
