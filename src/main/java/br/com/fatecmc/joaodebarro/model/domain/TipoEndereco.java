package br.com.fatecmc.joaodebarro.model.domain;

public enum TipoEndereco {
    
    REFERENCIA("Referência"),
    RESIDENCIAL("Residencial");
    
    private final String descricao;

    private TipoEndereco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public int getId() {
        return this.ordinal() + 1;
    }

    public static TipoEndereco idToEnum(int id) {
        switch (id) {
            case 1:
                return REFERENCIA;
            case 2:
                return RESIDENCIAL;
        }
        return null;
    }
    
}
