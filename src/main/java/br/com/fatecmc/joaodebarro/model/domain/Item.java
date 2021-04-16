package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class Item extends EntidadeDominio {
    private Produto produto;
    private int qtd;
    private boolean status;

    public Item() {
        super();
        this.produto = new Produto();
        this.qtd = 0;
        this.status = false;
    }
    
    public Item(Produto produto, int qtd, boolean status) {
        super();
        this.produto = produto;
        this.qtd = qtd;
        this.status = status;
    }

    public Item(Produto produto, int qtd, boolean status, int id, Date dt_cadastro) {
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
