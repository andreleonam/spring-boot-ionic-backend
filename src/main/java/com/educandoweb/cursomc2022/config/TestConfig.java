package com.educandoweb.cursomc2022.config;

import com.educandoweb.cursomc2022.entities.Categoria;
import com.educandoweb.cursomc2022.entities.Produto;
import com.educandoweb.cursomc2022.repositories.CategoriaRepository;
import com.educandoweb.cursomc2022.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Electronics");
        Categoria cat2 = new Categoria(null, "Books");
        Categoria cat3 = new Categoria(null, "Computers");
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Produto p1 = new Produto(null, "The Lord of the Rings", 90.5);
        Produto p2 = new Produto(null, "Smart TV", 2190.0);
        Produto p3 = new Produto(null, "Macbook Pro", 1250.0);
        Produto p4 = new Produto(null, "PC Gamer", 1200.0);
        Produto p5 = new Produto(null, "Rails for Dummies", 100.99);
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }
}
