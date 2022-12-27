package com.educandoweb.cursomc2022.config;

import com.educandoweb.cursomc2022.entities.Categoria;
import com.educandoweb.cursomc2022.entities.Cidade;
import com.educandoweb.cursomc2022.entities.Estado;
import com.educandoweb.cursomc2022.entities.Produto;
import com.educandoweb.cursomc2022.repositories.CategoriaRepository;
import com.educandoweb.cursomc2022.repositories.CidadeRepository;
import com.educandoweb.cursomc2022.repositories.EstadoRepository;
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

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

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

        p1.getCategorias().add(cat2);
        p2.getCategorias().add(cat1);
        p2.getCategorias().add(cat3);
        p3.getCategorias().add(cat3);
        p4.getCategorias().add(cat3);
        p4.getCategorias().add(cat2);
        p5.getCategorias().add(cat2);
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        Estado est1 = new Estado(null, "Minas Gerais", "MG");
        Estado est2 = new Estado(null, "São Paulo", "SP");
        estadoRepository.saveAll(Arrays.asList(est1, est2));

        Cidade cid1 = new Cidade(null, "Uberlandia", est1);
        Cidade cid2 = new Cidade(null, "São Paulo", est2);
        Cidade cid3 = new Cidade(null, "Campinas", est2);
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
    }
}
