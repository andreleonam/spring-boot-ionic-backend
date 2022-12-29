package com.educandoweb.cursomc2022.repositories;

import com.educandoweb.cursomc2022.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Transactional(readOnly = true)
    Cliente findClienteByEmail(String email);
}
