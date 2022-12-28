package com.educandoweb.cursomc2022.services;

import com.educandoweb.cursomc2022.entities.Pagamento;
import com.educandoweb.cursomc2022.repositories.PagamentoRepository;
import com.educandoweb.cursomc2022.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    public List<Pagamento> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public Pagamento findById(Long id) {
        Optional<Pagamento> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
