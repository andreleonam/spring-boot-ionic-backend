package com.educandoweb.cursomc2022.services;

import com.educandoweb.cursomc2022.entities.Pedido;
import com.educandoweb.cursomc2022.repositories.PedidoRepository;
import com.educandoweb.cursomc2022.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public List<Pedido> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public Pedido findById(Long id) {
        Optional<Pedido> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
