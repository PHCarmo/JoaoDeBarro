package br.com.fatecmc.joaodebarro.model.domain;

public enum StatusPedido {
    
    EM_PROCESSAMENTO("Em Processamento"),
    REPROVADA("Reprovada"),
    APROVADA("Aprovada"),
    EM_TRANSITO("Em Trânsito"),
    ENTREGUE("Entregue"),
    EM_TROCA("Em Troca"),
    TROCA_AUTORIZADA("Troca Autorizada");
        
    private final String descricao;

    private StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
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
