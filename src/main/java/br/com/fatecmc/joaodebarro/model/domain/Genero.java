package br.com.fatecmc.joaodebarro.model.domain;

public enum Genero {

    FEMININO("Feminino"),
    MASCULINO("Masculino");

    private final String descricao;

    private Genero(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public int getId() {
        return this.ordinal() + 1;
    }

    public static Genero idToEnum(int id) {
        switch (id) {
            case 1:
                return FEMININO;
            case 2:
                return MASCULINO;
        }
        return null;
    }

}
