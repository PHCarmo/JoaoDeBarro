package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class Pagamento extends EntidadeDominio {
    private Cartao cartao;
    private double valor;
    
    public Pagamento() {
        super();
        this.cartao = new Cartao();
        this.valor = 0.0;
    }

    public Pagamento(Cartao cartao, double valor) {
        super();
        this.cartao = cartao;
        this.valor = valor;
    }

    public Pagamento(Cartao cartao, double valor, int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.cartao = cartao;
        this.valor = valor;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
