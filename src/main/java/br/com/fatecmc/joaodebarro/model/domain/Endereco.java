package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class Endereco extends EntidadeDominio {
    private int cliente_id;
    private String apelido;
    private TipoLogradouro tipo_log;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private String observacao;
    private boolean cobranca;
    private boolean entrega;
    private TipoEndereco tipo;
    private TipoResidencia tipo_res;

    public Endereco() {
        super();
        this.cliente_id = 0;
        this.apelido = "";
        this.tipo_log = new TipoLogradouro();
        this.logradouro = "";
        this.numero = "";
        this.bairro = "";
        this.cep = "";
        this.cidade = "";
        this.estado = "";
        this.pais = "";
        this.observacao = "";
        this.cobranca = false;
        this.entrega = false;
        this.tipo = new TipoEndereco();
        this.tipo_res = new TipoResidencia();
    }

    public Endereco(int cliente_id, String apelido, TipoLogradouro tipo_log, String logradouro,
            String numero, String bairro, String cep, String cidade, String estado,
            String pais, String observacao, boolean cobranca, boolean entrega,
            TipoEndereco tipo, TipoResidencia tipo_res) {
        super();
        this.cliente_id = 0;
        this.apelido = apelido;
        this.tipo_log = tipo_log;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.observacao = observacao;
        this.cobranca = cobranca;
        this.entrega = entrega;
        this.tipo = tipo;
        this.tipo_res = tipo_res;
    }

    public Endereco(int cliente_id, String apelido, TipoLogradouro tipo_log, String logradouro,
            String numero, String bairro, String cep, String cidade, String estado,
            String pais, String observacao, boolean cobranca, boolean entrega,
            TipoEndereco tipo, TipoResidencia tipo_res, int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.cliente_id = cliente_id;
        this.apelido = apelido;
        this.tipo_log = tipo_log;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.observacao = observacao;
        this.cobranca = cobranca;
        this.entrega = entrega;
        this.tipo = tipo;
        this.tipo_res = tipo_res;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public TipoLogradouro getTipo_log() {
        return tipo_log;
    }

    public void setTipo_log(TipoLogradouro tipo_log) {
        this.tipo_log = tipo_log;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean getCobranca() {
        return cobranca;
    }

    public void setCobranca(boolean cobranca) {
        this.cobranca = cobranca;
    }

    public boolean getEntrega() {
        return entrega;
    }

    public void setEntrega(boolean entrega) {
        this.entrega = entrega;
    }

    public TipoEndereco getTipo() {
        return tipo;
    }

    public void setTipo(TipoEndereco tipo) {
        this.tipo = tipo;
    }

    public TipoResidencia getTipo_res() {
        return tipo_res;
    }

    public void setTipo_res(TipoResidencia tipo_res) {
        this.tipo_res = tipo_res;
    }
    
}
