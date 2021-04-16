package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class Reposicao extends EntidadeDominio {
    private Produto produto;
    private double valor_custo;
    private int qtd_entrada;
    private String fornecedor;
    private Date data_entrada;

    public Reposicao() {
        super();
        this.produto = new Produto();
        this.valor_custo = 0.0;
        this.qtd_entrada = 0;
        this.fornecedor = "";
        this.data_entrada = new Date();
    }
    
    public Reposicao(Produto produto, double valor_custo, int qtd_entrada,
            String fornecedor, Date data_entrada) {
        super();
        this.produto = produto;
        this.valor_custo = valor_custo;
        this.qtd_entrada = qtd_entrada;
        this.fornecedor = fornecedor;
        this.data_entrada = data_entrada;
    }

    public Reposicao(Produto produto, double valor_custo, int qtd_entrada,
            String fornecedor, Date data_entrada, int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.produto = produto;
        this.valor_custo = valor_custo;
        this.qtd_entrada = qtd_entrada;
        this.fornecedor = fornecedor;
        this.data_entrada = data_entrada;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getValor_custo() {
        return valor_custo;
    }

    public void setValor_custo(double valor_custo) {
        this.valor_custo = valor_custo;
    }

    public int getQtd_entrada() {
        return qtd_entrada;
    }

    public void setQtd_entrada(int qtd_entrada) {
        this.qtd_entrada = qtd_entrada;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }
    
}
