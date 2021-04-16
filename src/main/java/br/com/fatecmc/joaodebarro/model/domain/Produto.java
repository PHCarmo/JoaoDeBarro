package br.com.fatecmc.joaodebarro.model.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Produto extends EntidadeDominio {
    private String codigo;
    private TipoProduto tipo;
    private GrupoPrecificacao grupo;
    private StatusProduto status;
    private String descricao;
    private String marca;
    private String cor_tonalidade;
    private String material;
    private int comprimento;
    private int largura;
    private String codigo_barra;
    private int pei;
    private int qtd_estoque;
    private double valor_venda;
    private double margem_lucro;
    private String img_nome;
    private Collection<Categoria> categorias;

    public Produto() {
        super();
        this.codigo = "";
        this.tipo = null;
        this.grupo = null;
        this.status = null;
        this.descricao = "";
        this.marca = "";
        this.cor_tonalidade = "";
        this.material = "";
        this.comprimento = 0;
        this.largura = 0;
        this.codigo_barra = "";
        this.pei = 0;
        this.qtd_estoque = 0;
        this.valor_venda = 0.0;
        this.margem_lucro = 0.0;
        this.img_nome = "";
        this.categorias = new ArrayList<>();
    }
    
    public Produto(String codigo, TipoProduto tipo, GrupoPrecificacao grupo,
            StatusProduto status, String descricao, String marca, String cor_tonalidade,
            String material, int comprimento, int largura, String codigo_barra,
            int pei, int qtd_estoque, double valor_venda, double margem_lucro,
            String img_nome, Collection<Categoria> categorias) {
        super();
        this.codigo = codigo;
        this.tipo = tipo;
        this.grupo = grupo;
        this.status = status;
        this.descricao = descricao;
        this.marca = marca;
        this.cor_tonalidade = cor_tonalidade;
        this.material = material;
        this.comprimento = comprimento;
        this.largura = largura;
        this.codigo_barra = codigo_barra;
        this.pei = pei;
        this.qtd_estoque = qtd_estoque;
        this.valor_venda = valor_venda;
        this.margem_lucro = margem_lucro;
        this.img_nome = img_nome;
        this.categorias = categorias;
    }

    public Produto(String codigo, TipoProduto tipo, GrupoPrecificacao grupo,
            StatusProduto status, String descricao, String marca, String cor_tonalidade,
            String material, int comprimento, int largura, String codigo_barra,
            int pei, int qtd_estoque, double valor_venda, double margem_lucro,
            String img_nome, Collection<Categoria> categorias, int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.codigo = codigo;
        this.tipo = tipo;
        this.grupo = grupo;
        this.status = status;
        this.descricao = descricao;
        this.marca = marca;
        this.cor_tonalidade = cor_tonalidade;
        this.material = material;
        this.comprimento = comprimento;
        this.largura = largura;
        this.codigo_barra = codigo_barra;
        this.pei = pei;
        this.qtd_estoque = qtd_estoque;
        this.valor_venda = valor_venda;
        this.margem_lucro = margem_lucro;
        this.img_nome = img_nome;
        this.categorias = categorias;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }

    public GrupoPrecificacao getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoPrecificacao grupo) {
        this.grupo = grupo;
    }

    public StatusProduto getStatus() {
        return status;
    }

    public void setStatus(StatusProduto status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor_tonalidade() {
        return cor_tonalidade;
    }

    public void setCor_tonalidade(String cor_tonalidade) {
        this.cor_tonalidade = cor_tonalidade;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getComprimento() {
        return comprimento;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public String getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(String codigo_barra) {
        this.codigo_barra = codigo_barra;
    }

    public int getPei() {
        return pei;
    }

    public void setPei(int pei) {
        this.pei = pei;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public double getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(double valor_venda) {
        this.valor_venda = valor_venda;
    }

    public double getMargem_lucro() {
        return margem_lucro;
    }

    public void setMargem_lucro(double margem_lucro) {
        this.margem_lucro = margem_lucro;
    }

    public String getImg_nome() {
        return img_nome;
    }

    public void setImg_nome(String img_nome) {
        this.img_nome = img_nome;
    }

    public Collection<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Collection<Categoria> categorias) {
        this.categorias = categorias;
    }
    
}
