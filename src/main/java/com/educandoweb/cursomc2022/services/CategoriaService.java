package com.educandoweb.cursomc2022.services;

import com.educandoweb.cursomc2022.entities.Categoria;
import com.educandoweb.cursomc2022.repositories.CategoriaRepository;
import com.educandoweb.cursomc2022.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public Categoria findById(Long id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Categoria insert(Categoria obj) {
        return repository.save(obj);
    }
/*
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }

    }

    public User update(Long id, User obj) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
             throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setphone(obj.getphone());
    }
     */
}
