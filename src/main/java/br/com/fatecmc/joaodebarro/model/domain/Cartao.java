package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class Cartao extends EntidadeDominio {
    private BandeiraCartao bandeira;
    private String numero;
    private String nome;
    private String cvv;

    public Cartao() {
        super();
        this.bandeira = null;
        this.numero = "";
        this.nome = "";
        this.cvv = "";
    }

    public Cartao(BandeiraCartao bandeira, String numero, String nome, String cvv) {
        super();
        this.bandeira = bandeira;
        this.numero = numero;
        this.nome = nome;
        this.cvv = cvv;
    }

    public Cartao(BandeiraCartao bandeira, String numero, String nome, String cvv,
            int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.bandeira = bandeira;
        this.numero = numero;
        this.nome = nome;
        this.cvv = cvv;
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
    
}
