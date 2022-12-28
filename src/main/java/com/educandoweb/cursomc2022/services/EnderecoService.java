package com.educandoweb.cursomc2022.services;

import com.educandoweb.cursomc2022.entities.Endereco;
import com.educandoweb.cursomc2022.repositories.EnderecoRepository;
import com.educandoweb.cursomc2022.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public List<Endereco> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public Endereco findById(Long id) {
        Optional<Endereco> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
