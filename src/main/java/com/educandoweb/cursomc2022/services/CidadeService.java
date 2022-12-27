package com.educandoweb.cursomc2022.services;

import com.educandoweb.cursomc2022.entities.Cidade;
import com.educandoweb.cursomc2022.repositories.CidadeRepository;
import com.educandoweb.cursomc2022.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    public List<Cidade> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public Cidade findById(Long id) {
        Optional<Cidade> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
