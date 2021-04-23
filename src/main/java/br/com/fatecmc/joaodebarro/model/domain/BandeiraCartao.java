package br.com.fatecmc.joaodebarro.model.domain;

public enum BandeiraCartao {

    AMERICAN_EX ("American Express",    "card-americanex.png"),
    DINERS_C    ("Diners Club",         "card-default.png"),
    ELO         ("Elo",                 "card-default.png"),
    HIPERC      ("Hipercard",           "card-default.png"),
    MASTERC     ("MasterCard",          "card-mastercard.png"),
    VISA        ("Visa",                "card-visa.png");

    private final String descricao;
    private final String icon_nome;

    private BandeiraCartao(String descricao, String icon_nome) {
        this.descricao = descricao;
        this.icon_nome = icon_nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getIcon_nome() {
        return icon_nome;
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
