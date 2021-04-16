package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class ValeTroca extends EntidadeDominio {
    private String codigo;
    private double valor;
    
    public ValeTroca() {
        super();
        this.codigo = "";
        this.valor = 0.0;
    }

    public ValeTroca(String codigo, double valor) {
        super();
        this.codigo = codigo;
        this.valor = valor;
    }

    public ValeTroca(String codigo, double valor, int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.codigo = codigo;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
