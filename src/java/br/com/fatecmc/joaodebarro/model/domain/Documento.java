package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class Documento extends EntidadeDominio {
    private String codigo;
    private Date dt_validade;
    private TipoDocumento tipo;

    public Documento() {
        super();
        this.codigo = "";
        this.dt_validade = new Date();
        this.tipo = new TipoDocumento();
    }

    public Documento(String codigo, Date dt_validade, TipoDocumento tipo) {
        super();
        this.codigo = codigo;
        this.dt_validade = dt_validade;
        this.tipo = tipo;
    }

    public Documento(String codigo, Date dt_validade, TipoDocumento tipo, int id,
            Date dt_cadastro) {
        super(id, dt_cadastro);
        this.codigo = codigo;
        this.dt_validade = dt_validade;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDt_validade() {
        return dt_validade;
    }

    public void setDt_validade(Date dt_validade) {
        this.dt_validade = dt_validade;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
    }
    
}
