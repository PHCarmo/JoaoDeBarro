package br.com.fatecmc.joaodebarro.model.domain;

public enum StatusProduto {
    
    ATIVO("Ativo"),
    INATIVO("Inativo"),
    EM_LIBERACAO("Em Liberação");
    
    private final String descricao;

    private StatusProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public int getId() {
        return this.ordinal() + 1;
    }

    public static StatusProduto idToEnum(int id) {
        switch (id) {
            case 1:
                return ATIVO;
            case 2:
                return INATIVO;
            case 3:
                return EM_LIBERACAO;
        }
        return null;
    }
    
}
