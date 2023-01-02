package com.educandoweb.cursomc2022.services;

import com.educandoweb.cursomc2022.entities.ItemPedido;
import com.educandoweb.cursomc2022.entities.PagamentoComBoleto;
import com.educandoweb.cursomc2022.entities.Pedido;
import com.educandoweb.cursomc2022.entities.enums.EstadoPagamento;
import com.educandoweb.cursomc2022.repositories.ItemPedidoRepository;
import com.educandoweb.cursomc2022.repositories.PagamentoRepository;
import com.educandoweb.cursomc2022.repositories.PedidoRepository;
import com.educandoweb.cursomc2022.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

import static java.time.Instant.now;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EnderecoService enderecoService;

    public List<Pedido> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public Pedido findById(Long id) {
        Optional<Pedido> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public Pedido insert(Pedido obj) {
        obj.setId(null);

        obj.setMomento(now());

        obj.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);
        if (obj.getPagamento() instanceof PagamentoComBoleto) {
            PagamentoComBoleto pgto = (PagamentoComBoleto) obj.getPagamento();
            PagamentoComBoletoService.preencherPagamentoComBoleto(pgto, obj.getMomento());
        }
        pagamentoRepository.save(obj.getPagamento());

        obj.setCliente(clienteService.findById(obj.getCliente().getId()));

        obj.setEnderecoDeEntrega(enderecoService.findById(obj.getEnderecoDeEntrega().getId()));

        for (ItemPedido ip : obj.getItens()) {
            ip.setDesconto(0.0);
            ip.setPreco(produtoService.findById(ip.getProduto().getId()).getPreco());
            ip.setPedido(obj);
        }
        itemPedidoRepository.saveAll(obj.getItens());

        return repository.save(obj);
    }
}
