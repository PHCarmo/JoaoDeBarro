package br.com.fatecmc.joaodebarro.model.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Carrinho extends EntidadeDominio {
    private Collection<Item> itens;
    private Session session;

    public Carrinho() {
        super();
        this.itens = new ArrayList<>();
        this.session = new Session();
    }
    
    public Carrinho(Collection<Item> itens, Session session) {
        super();
        this.itens = itens;
        this.session = session;
    }

    public Carrinho(Collection<Item> itens, Session session, int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.itens = itens;
        this.session = session;
    }

    public Collection<Item> getItens() {
        return itens;
    }

    public void setItens(Collection<Item> itens) {
        this.itens = itens;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
    
}
