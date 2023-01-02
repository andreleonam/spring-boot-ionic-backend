package com.educandoweb.cursomc2022.entities.enums;

public enum TipoCliente {
    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    private Integer codigo;
    private String descricao;


    private TipoCliente(Integer codigo, String s) {
        this.codigo = codigo;
    }

    public static TipoCliente valueOf(Integer codigo) {
        for (TipoCliente value : TipoCliente.values()) {
            if (value.getCodigo() == codigo) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TipoCliente code");
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
