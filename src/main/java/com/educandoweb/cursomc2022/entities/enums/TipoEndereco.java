package com.educandoweb.cursomc2022.entities.enums;

public enum TipoEndereco {
    RESIDENCIAL(1, "Residencial"),
    COMERCIAL(2, "Comercial"),
    OBRA(3, "Obra");

    private int codigo;
    private String descricao;


    private TipoEndereco(int codigo, String s) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoEndereco valueOf(int codigo){
        for (TipoEndereco value : TipoEndereco.values()){
            if (value.getCodigo() == codigo) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TipoCliente code");
    }
}
