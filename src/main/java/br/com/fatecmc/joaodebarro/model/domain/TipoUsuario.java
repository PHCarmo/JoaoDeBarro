package br.com.fatecmc.joaodebarro.model.domain;

public enum TipoUsuario {
    
    ADM("Administrador"),
    CLIENTE("Cliente");
    
    private final String descricao;

    private TipoUsuario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public int getId() {
        return this.ordinal() + 1;
    }

    public static TipoUsuario idToEnum(int id) {
        switch (id) {
            case 1:
                return ADM;
            case 2:
                return CLIENTE;
        }
        return null;
    }
    
}
