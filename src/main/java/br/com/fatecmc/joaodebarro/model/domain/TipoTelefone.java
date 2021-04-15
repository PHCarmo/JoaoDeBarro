package br.com.fatecmc.joaodebarro.model.domain;

public enum TipoTelefone {
    
    CELULAR("Celular"),
    FIXO("Fixo"),
    VOIP("VoIP");
    
    private final String descricao;

    private TipoTelefone(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public int getId() {
        return this.ordinal() + 1;
    }

    public static TipoTelefone idToEnum(int id) {
        switch (id) {
            case 1:
                return CELULAR;
            case 2:
                return FIXO;
            case 3:
                return VOIP;
        }
        return null;
    }
    
}
