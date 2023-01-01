package com.educandoweb.cursomc2022.services;

import com.educandoweb.cursomc2022.entities.Categoria;
import com.educandoweb.cursomc2022.entities.Produto;
import com.educandoweb.cursomc2022.repositories.CategoriaRepository;
import com.educandoweb.cursomc2022.repositories.ProdutoRepository;
import com.educandoweb.cursomc2022.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Produto> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public Produto findById(Long id) {
        Optional<Produto> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Page<Produto> search(String nome, List<Long> ids, Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        List<Categoria> categorias = (List<Categoria>) categoriaRepository.findAllById(ids);
        return repository.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);

    }
}
