package br.com.fatecmc.joaodebarro.model.domain;

public enum BandeiraCartao {

    AMERICAN_EX("American Express"),
    DINERS_C("Diners Club"),
    ELO("Elo"),
    HIPERC("Hipercard"),
    MASTERC("MasterCard"),
    VISA("Visa");

    private final String descricao;

    private BandeiraCartao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public int getId() {
        return this.ordinal() + 1;
    }

    public static BandeiraCartao idToEnum(int id) {
        switch (id) {
            case 1:
                return AMERICAN_EX;
            case 2:
                return DINERS_C;
            case 3:
                return ELO;
            case 4:
                return HIPERC;
            case 5:
                return MASTERC;
            case 6:
                return VISA;
        }
        return null;
    }

}
