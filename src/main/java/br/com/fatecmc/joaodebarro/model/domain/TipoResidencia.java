package br.com.fatecmc.joaodebarro.model.domain;

public enum TipoResidencia {
    
    APARTAMENTO("Apartamento"),
    CASA("Casa"),
    CONDOMINIO("Condomínio"),
    SOBRADO("Sobrado");
    
    private final String descricao;

    private TipoResidencia(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public int getId() {
        return this.ordinal() + 1;
    }

    public static TipoResidencia idToEnum(int id) {
        switch (id) {
            case 1:
                return APARTAMENTO;
            case 2:
                return CASA;
            case 3:
                return CONDOMINIO;
            case 4:
                return SOBRADO;
        }
        return null;
    }
    
}
