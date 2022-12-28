package com.educandoweb.cursomc2022.entities.enums;

public enum TipoCliente {
    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    private int codigo;
    private String descricao;


    private TipoCliente(int codigo, String s) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente valueOf(int codigo){
        for (TipoCliente value : TipoCliente.values()){
            if (value.getCodigo() == codigo) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TipoCliente code");
    }
}
