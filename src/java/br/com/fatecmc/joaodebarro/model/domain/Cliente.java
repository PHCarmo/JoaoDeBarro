package br.com.fatecmc.joaodebarro.model.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Cliente extends Pessoa {
    private String nome;
    private TipoCliente tipo;
    private Collection<Endereco> enderecos;

    public Cliente() {
        super();
        this.nome = "";
        this.tipo = new TipoCliente();
        this.enderecos = new ArrayList<>();
    }

    public Cliente(String nome, TipoCliente tipo, Collection<Endereco> enderecos) {
        super();
        this.nome = nome;
        this.tipo = tipo;
        this.enderecos = enderecos;
    }

    public Cliente(String nome, TipoCliente tipo, Collection<Endereco> enderecos,
            Collection<Documento> documentos) {
        super(documentos);
        this.nome = nome;
        this.tipo = tipo;
        this.enderecos = enderecos;
    }

    public Cliente(String nome, TipoCliente tipo, Collection<Endereco> enderecos,
            Collection<Documento> documentos, int id, Date dt_cadastro) {
        super(documentos, id, dt_cadastro);
        this.nome = nome;
        this.tipo = tipo;
        this.enderecos = enderecos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public Collection<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Collection<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
}
