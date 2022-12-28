package com.educandoweb.cursomc2022.services;

import com.educandoweb.cursomc2022.entities.Cliente;
import com.educandoweb.cursomc2022.repositories.ClienteRepository;
import com.educandoweb.cursomc2022.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public Cliente findById(Long id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
