package com.educandoweb.cursomc2022.repositories;

import com.educandoweb.cursomc2022.entities.Categoria;
import com.educandoweb.cursomc2022.entities.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
