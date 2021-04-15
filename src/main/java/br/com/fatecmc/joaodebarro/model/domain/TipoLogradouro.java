package br.com.fatecmc.joaodebarro.model.domain;

public enum TipoLogradouro {
    
    ALAMEDA("Alameda"),
    AVENIDA("Avenida"),
    ESTRADA("Estrada"),
    RODOVIA("Rodovia"),
    RUA("Rua"),
    TRAVESSA("Travessa"),
    VIA("Via"),
    VIADUTO("Viaduto");
    
    private final String descricao;

    private TipoLogradouro(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public int getId() {
        return this.ordinal() + 1;
    }
    
    public static TipoLogradouro idToEnum(int id) {
        switch (id) {
            case 1:
                return ALAMEDA;
            case 2:
                return AVENIDA;
            case 3:
                return ESTRADA;
            case 4:
                return RODOVIA;
            case 5:
                return RUA;
            case 6:
                return TRAVESSA;
            case 7:
                return VIA;
            case 8:
                return VIADUTO;
        }
        return null;
    }
    
}
