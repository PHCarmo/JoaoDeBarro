package br.com.fatecmc.joaodebarro.model.domain;

public enum Categoria {

    AZULEJO("Azulejo"),
    FAIXA("Faixa"),
    FILETE("Filete"),
    LADRILHO("Ladrilho"),
    MOSAICO("Mosaico"),
    PASTILHA("Pastilha"),
    PEDRA_NATU("Pedra Natural"),
    PISO_CERA("Piso Cerâmico"),
    PISO_LAMI("Piso Laminado"),
    PISO_MONO("Piso Monolítico"),
    PISO_VINI("Piso Vinílico"),
    PORCELANATO("Porcelanato"),
    REV_EXTERNO("Revestimento Externo"),
    REV_INTERNO("Revestimento Interno"),
    RODAPE("Rodapé"),
    SOLEIRA("Soleira");
    
    private final String descricao;

    private Categoria(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public int getId() {
        return this.ordinal() + 1;
    }

    public static Categoria idToEnum(int id) {
        switch (id) {
            case 1:
                return AZULEJO;
            case 2:
                return FAIXA;
            case 3:
                return FILETE;
            case 4:
                return LADRILHO;
            case 5:
                return MOSAICO;
            case 6:
                return PASTILHA;
            case 7:
                return PEDRA_NATU;
            case 8:
                return PISO_CERA;
            case 9:
                return PISO_LAMI;
            case 10:
                return PISO_MONO;
            case 11:
                return PISO_VINI;
            case 12:
                return PORCELANATO;
            case 13:
                return REV_EXTERNO;
            case 14:
                return REV_INTERNO;
            case 15:
                return RODAPE;
            case 16:
                return SOLEIRA;
        }
        return null;
    }

}
