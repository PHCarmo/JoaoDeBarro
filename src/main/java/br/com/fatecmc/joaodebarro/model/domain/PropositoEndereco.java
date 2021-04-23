package br.com.fatecmc.joaodebarro.model.domain;

public enum PropositoEndereco {
    
    ENTR_COBR("Entrega e Cobrança", true, true),
    ENTR("Somente Entrega", true, false),
    COBR("Somente Cobrança", false, true);
    
    private final String descricao;
    private final boolean entrega;
    private final boolean cobranca;

    private PropositoEndereco(String descricao, boolean entrega, boolean cobranca) {
        this.descricao = descricao;
        this.entrega = entrega;
        this.cobranca = cobranca;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean getEntrega() {
        return entrega;
    }

    public boolean getCobranca() {
        return cobranca;
    }
    
    public int getId() {
        return this.ordinal() + 1;
    }

    public static PropositoEndereco idToEnum(int id) {
        switch (id) {
            case 1:
                return ENTR_COBR;
            case 2:
                return ENTR;
            case 3:
                return COBR;
        }
        return null;
    }
    
}
