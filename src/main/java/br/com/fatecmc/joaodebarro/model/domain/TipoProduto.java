package br.com.fatecmc.joaodebarro.model.domain;

public enum TipoProduto {
    
    PISO("Piso"),
    REVESTIMENTO("Revestimento");
    
    private final String descricao;

    private TipoProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public int getId() {
        return this.ordinal() + 1;
    }

    public static TipoProduto idToEnum(int id) {
        switch (id) {
            case 1:
                return PISO;
            case 2:
                return REVESTIMENTO;
        }
        return null;
    }
    
}
