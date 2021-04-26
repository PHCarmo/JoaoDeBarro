package br.com.fatecmc.joaodebarro.model.domain;

public enum StatusPedido {
    
    EM_PROCESSAMENTO("Em Processamento", "lightblue"),
    REPROVADA("Reprovada", "red"),
    APROVADA("Aprovada", "blue"),
    EM_TRANSITO("Em Trânsito", "orange"),
    ENTREGUE("Entregue", "green"),
    EM_TROCA("Em Troca", "yellow"),
    TROCA_AUTORIZADA("Troca Autorizada", "lightgreen");
        
    private final String descricao;
    private final String cor;

    private StatusPedido(String descricao, String cor) {
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

    public static StatusPedido idToEnum(int id) {
        switch (id) {
            case 1:
                return EM_PROCESSAMENTO;
            case 2:
                return REPROVADA;
            case 3:
                return APROVADA;
            case 4:
                return EM_TRANSITO;
            case 5:
                return ENTREGUE;
            case 6:
                return EM_TROCA;
            case 7:
                return TROCA_AUTORIZADA;
        }
        return null;
    }
    
}
