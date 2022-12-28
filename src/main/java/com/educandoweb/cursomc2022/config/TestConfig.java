package com.educandoweb.cursomc2022.config;

import com.educandoweb.cursomc2022.entities.*;
import com.educandoweb.cursomc2022.entities.enums.EstadoPagamento;
import com.educandoweb.cursomc2022.entities.enums.TipoCliente;
import com.educandoweb.cursomc2022.entities.enums.TipoEndereco;
import com.educandoweb.cursomc2022.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

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

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informatica");
        Categoria cat2 = new Categoria(null, "Escritorio");
        Categoria cat3 = new Categoria(null, "Automotivo");
        Categoria cat4 = new Categoria(null, "Material Hidraulico");
        Categoria cat5 = new Categoria(null, "Livro");
        Categoria cat6 = new Categoria(null, "Piso e Revestimento");
        Categoria cat7 = new Categoria(null, "Eletrodomestico");
        Categoria cat8 = new Categoria(null, "Cama, mesa e banho");
        Categoria cat9 = new Categoria(null, "Tinta e Vernize");
        Categoria cat10 = new Categoria(null, "Parafuso");
        Categoria cat11 = new Categoria(null, "Calçado");
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10, cat11));

        Produto p1 = new Produto(null, "Computador", 2000.0);
        Produto p2 = new Produto(null, "Impressora", 800.0);
        Produto p3 = new Produto(null, "Mouse", 80.0);
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        p1.getCategorias().add(cat1);
        p2.getCategorias().add(cat1);
        p2.getCategorias().add(cat2);
        p3.getCategorias().add(cat1);
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado(null, "Minas Gerais", "MG");
        Estado est2 = new Estado(null, "São Paulo", "SP");
        estadoRepository.saveAll(Arrays.asList(est1, est2));

        Cidade cid1 = new Cidade(null, "Uberlandia", est1);
        Cidade cid2 = new Cidade(null, "São Paulo", est2);
        Cidade cid3 = new Cidade(null, "Campinas", est2);
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "12345678901", TipoCliente.PESSOA_FISICA);

        cli1.getTelefones().addAll(Arrays.asList("990001234", "32001234"));

        Endereco e1 = new Endereco(null, "Rua Flores", "300", "AP203", "Jardim", "49010123", TipoEndereco.RESIDENCIAL, cli1, cid1);
        Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "49020123", TipoEndereco.OBRA, cli1, cid2);

        cli1.getEnderecos().add(e1);
        cli1.getEnderecos().add(e2);
        clienteRepository.saveAll(List.of(cli1));

        enderecoRepository.saveAll(Arrays.asList(e1, e2));

        Pedido ped1 = new Pedido(null, Instant.parse("2017-09-30T10:32:00Z"), cli1, e1);
        Pedido ped2 = new Pedido(null, Instant.parse("2017-10-10T19:35:00Z"), cli1, e2);

        Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
        Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, Instant.parse("2017-10-20T23:59:59Z"), null);

        ped1.setPagamento(pgto1);
        ped2.setPagamento(pgto2);

        cli1.getPedidos().add(ped1);
        cli1.getPedidos().add(ped2);
        clienteRepository.saveAll(List.of(cli1));

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));

        ItemPedido ip1 = new ItemPedido(ped1, p1, 0.0, 1, p1.getPreco());
        ItemPedido ip2 = new ItemPedido(ped1, p3, 0.0, 2, p3.getPreco());
        ItemPedido ip3 = new ItemPedido(ped2, p2, 100.0, 1, p2.getPreco());

        ped1.getItens().add(ip1);
        ped1.getItens().add(ip2);
        ped2.getItens().add(ip3);

        p1.getItens().add(ip1);
        p2.getItens().add(ip3);
        p3.getItens().add(ip2);

        itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
    }
}
