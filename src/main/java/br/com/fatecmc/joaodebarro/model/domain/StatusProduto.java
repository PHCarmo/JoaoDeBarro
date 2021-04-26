package br.com.fatecmc.joaodebarro.model.domain;

public enum StatusProduto {
    
    ATIVO("Ativo", "green"),
    INATIVO("Inativo", "grey"),
    EM_LIBERACAO("Em Liberação", "orange");
    
    private final String descricao;
    private final String cor;

    private StatusProduto(String descricao, String cor) {
        this.descricao = descricao;
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public String getCor() {
        return cor;
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
