package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class Cartao extends EntidadeDominio {
    private BandeiraCartao bandeira;
    private String numero;
    private String nome;
    private String cvv;
    private Date validade;

    public Cartao() {
        super();
        this.bandeira = null;
        this.numero = "";
        this.nome = "";
        this.cvv = "";
        this.validade =  new Date();
    }

    public Cartao(BandeiraCartao bandeira, String numero, String nome, String cvv,
            Date validade) {
        super();
        this.bandeira = bandeira;
        this.numero = numero;
        this.nome = nome;
        this.cvv = cvv;
        this.validade = validade;
    }

    public Cartao(BandeiraCartao bandeira, String numero, String nome, String cvv,
            Date validade, int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.bandeira = bandeira;
        this.numero = numero;
        this.nome = nome;
        this.cvv = cvv;
        this.validade = validade;
    }

    public BandeiraCartao getBandeira() {
        return bandeira;
    }

    public void setBandeira(BandeiraCartao bandeira) {
        this.bandeira = bandeira;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }
    
}
