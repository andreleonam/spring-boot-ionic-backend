package com.educandoweb.cursomc2022.repositories;

import com.educandoweb.cursomc2022.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
