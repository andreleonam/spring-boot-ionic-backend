package com.educandoweb.cursomc2022.repositories;

import com.educandoweb.cursomc2022.entities.Categoria;
import com.educandoweb.cursomc2022.entities.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Transactional(readOnly = true)
    Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);

}
