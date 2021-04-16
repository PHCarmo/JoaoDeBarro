package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class Cupom extends EntidadeDominio {
    private String nome;
    private double valor;
    private boolean status;
    
    public Cupom() {
        super();
        this.nome = "";
        this.valor = 0.0;
        this.status = false;
    }

    public Cupom(String nome, double valor, boolean status) {
        super();
        this.nome = nome;
        this.valor = valor;
        this.status = status;
    }

    public Cupom(String nome, double valor, boolean status, int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.nome = nome;
        this.valor = valor;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
