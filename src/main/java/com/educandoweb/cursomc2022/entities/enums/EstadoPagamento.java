package com.educandoweb.cursomc2022.entities.enums;

public enum EstadoPagamento {
    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int codigo;
    private String descricao;


    private EstadoPagamento(int codigo, String s) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoPagamento valueOf(int codigo){
        for (EstadoPagamento value : EstadoPagamento.values()){
            if (value.getCodigo() == codigo) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid EstadoPagamento code");
    }
}
