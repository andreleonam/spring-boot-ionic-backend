package com.educandoweb.cursomc2022.services;

import com.educandoweb.cursomc2022.dto.CategoriaDTO;
import com.educandoweb.cursomc2022.entities.Categoria;
import com.educandoweb.cursomc2022.repositories.CategoriaRepository;
import com.educandoweb.cursomc2022.services.exceptions.DataIntegrityException;
import com.educandoweb.cursomc2022.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    private void updateData(Categoria entity, Categoria obj) {
        entity.setNome(obj.getNome());
    }

    public Categoria update(Long id, Categoria obj) {
        try {
            Categoria entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Exclude is not possible");
        }

    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Categoria fromDto(CategoriaDTO objDto) {
        return new Categoria(objDto.getId(), objDto.getNome());
    }

}
