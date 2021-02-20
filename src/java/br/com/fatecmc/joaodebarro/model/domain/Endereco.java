package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class Endereco extends EntidadeDominio {
    private String logradouro;
    private String numero;
    private String cep;
    private String complemento;
    private Cidade cidade;
    private TipoEndereco tipo;

    public Endereco() {
        super();
        this.logradouro = "";
        this.numero = "";
        this.cep = "";
        this.complemento = "";
        this.cidade = new Cidade();
        this.tipo = new TipoEndereco();
    }

    public Endereco(String logradouro, String numero, String cep,
            String complemento, Cidade cidade, TipoEndereco tipo) {
        super();
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
        this.cidade = cidade;
        this.tipo = tipo;
    }

    public Endereco(String logradouro, String numero, String cep,
            String complemento, Cidade cidade, TipoEndereco tipo, int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
        this.cidade = cidade;
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public TipoEndereco getTipo() {
        return tipo;
    }

    public void setTipo(TipoEndereco tipo) {
        this.tipo = tipo;
    }
    
}
