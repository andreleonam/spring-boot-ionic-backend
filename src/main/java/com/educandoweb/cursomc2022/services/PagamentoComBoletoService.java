package com.educandoweb.cursomc2022.services;

import com.educandoweb.cursomc2022.entities.PagamentoComBoleto;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class PagamentoComBoletoService {

    public static void preencherPagamentoComBoleto(PagamentoComBoleto pgto, Instant momento) {
        pgto.setDataVencimento(momento.plus(10, ChronoUnit.DAYS));
    }
}
