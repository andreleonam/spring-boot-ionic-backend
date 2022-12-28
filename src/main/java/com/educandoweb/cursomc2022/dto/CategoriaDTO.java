package com.educandoweb.cursomc2022.dto;

import com.educandoweb.cursomc2022.entities.Categoria;

import java.io.Serializable;

public class CategoriaDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
