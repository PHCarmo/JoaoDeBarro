package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class Item extends EntidadeDominio {
    private Produto produto;
    private int qtd;
    private boolean status;
    private boolean troca;

    public Item() {
        super();
        this.produto = new Produto();
        this.qtd = 0;
        this.status = false;
        this.troca = false;
    }
    
    public Item(Produto produto, int qtd, boolean status, boolean troca) {
        super();
        this.produto = produto;
        this.qtd = qtd;
        this.status = status;
        this.troca = troca;
    }

    public Item(Produto produto, int qtd, boolean status, boolean troca, int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.produto = produto;
        this.qtd = qtd;
        this.status = status;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public boolean getTroca() {
        return troca;
    }

    public void setTroca(boolean troca) {
        this.troca = troca;
    }
    
}
