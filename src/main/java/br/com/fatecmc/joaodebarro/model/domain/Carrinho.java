package br.com.fatecmc.joaodebarro.model.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Carrinho extends EntidadeDominio {
    private Collection<Item> itens;

    public Carrinho() {
        super();
        this.itens = new ArrayList<>();
    }
    
    public Carrinho(Collection<Item> itens) {
        super();
        this.itens = itens;
    }

    public Carrinho(Collection<Item> itens, int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.itens = itens;
    }

    public Collection<Item> getItens() {
        return itens;
    }

    public void setItens(Collection<Item> itens) {
        this.itens = itens;
    }
    
}
