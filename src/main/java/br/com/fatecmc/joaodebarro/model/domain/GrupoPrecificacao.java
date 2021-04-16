package br.com.fatecmc.joaodebarro.model.domain;

public enum GrupoPrecificacao {
    
    PADRAO("Padrão"),
    PROMOCAO("Promoção"),
    GRUPO_X("Grupo X");
    
    private final String descricao;

    private GrupoPrecificacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public int getId() {
        return this.ordinal() + 1;
    }

    public static GrupoPrecificacao idToEnum(int id) {
        switch (id) {
            case 1:
                return PADRAO;
            case 2:
                return PROMOCAO;
            case 3:
                return GRUPO_X;
        }
        return null;
    }
    
}
