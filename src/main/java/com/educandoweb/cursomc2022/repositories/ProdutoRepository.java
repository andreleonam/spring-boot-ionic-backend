package com.educandoweb.cursomc2022.repositories;

import com.educandoweb.cursomc2022.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
