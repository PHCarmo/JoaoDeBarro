package br.com.fatecmc.joaodebarro.model.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Pedido extends EntidadeDominio {
    private String codigo;
    private Carrinho carrinho;
    private Cliente cliente;
    private StatusPedido status;
    private Endereco end_entrega;
    private Endereco end_cobranca;
    private Cupom cupom;
    private Collection<ValeTroca> vales;
    private Collection<Pagamento> pagamentos;
    private double valor_frete;
    private double valor_desconto;
    private double valor_produtos;
    
    public Pedido() {
        super();
        this.codigo = "";
        this.carrinho = new Carrinho();
        this.cliente = new Cliente();
        this.status = null;
        this.end_entrega = new Endereco();
        this.end_cobranca = new Endereco();
        this.cupom = new Cupom();
        this.vales = new ArrayList<>();
        this.pagamentos = new ArrayList<>();
        this.valor_frete = 0.0;
        this.valor_desconto = 0.0;
        this.valor_produtos = 0.0;
    }

    public Pedido(String codigo, Carrinho carrinho, Cliente cliente, StatusPedido status,
            Endereco end_entrega, Endereco end_cobranca, Cupom cupom, Collection<ValeTroca> vales,
            Collection<Pagamento> pagamentos, double valor_frete, double valor_desconto,
            double valor_produtos) {
        super();
        this.codigo = codigo;
        this.carrinho = carrinho;
        this.cliente = cliente;
        this.status = status;
        this.end_entrega = end_entrega;
        this.end_cobranca = end_cobranca;
        this.cupom = cupom;
        this.vales = vales;
        this.pagamentos = pagamentos;
        this.valor_frete = valor_frete;
        this.valor_desconto = valor_desconto;
        this.valor_produtos = valor_produtos;
    }

    public Pedido(String codigo, Carrinho carrinho, Cliente cliente, StatusPedido status,
            Endereco end_entrega, Endereco end_cobranca, Cupom cupom, Collection<ValeTroca> vales,
            Collection<Pagamento> pagamentos, double valor_frete, double valor_desconto,
            double valor_produtos, int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.codigo = codigo;
        this.carrinho = carrinho;
        this.cliente = cliente;
        this.status = status;
        this.end_entrega = end_entrega;
        this.end_cobranca = end_cobranca;
        this.cupom = cupom;
        this.vales = vales;
        this.pagamentos = pagamentos;
        this.valor_frete = valor_frete;
        this.valor_desconto = valor_desconto;
        this.valor_produtos = valor_produtos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Endereco getEnd_entrega() {
        return end_entrega;
    }

    public void setEnd_entrega(Endereco end_entrega) {
        this.end_entrega = end_entrega;
    }

    public Endereco getEnd_cobranca() {
        return end_cobranca;
    }

    public void setEnd_cobranca(Endereco end_cobranca) {
        this.end_cobranca = end_cobranca;
    }

    public Cupom getCupom() {
        return cupom;
    }

    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    public Collection<ValeTroca> getVales() {
        return vales;
    }

    public void setVales(Collection<ValeTroca> vales) {
        this.vales = vales;
    }

    public Collection<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(Collection<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }
    
    public double getValor_frete() {
        return valor_frete;
    }

    public void setValor_frete(double valor_frete) {
        this.valor_frete = valor_frete;
    }

    public double getValor_desconto() {
        return valor_desconto;
    }

    public void setValor_desconto(double valor_desconto) {
        this.valor_desconto = valor_desconto;
    }

    public double getValor_produtos() {
        return valor_produtos;
    }

    public void setValor_produtos(double valor_produtos) {
        this.valor_produtos = valor_produtos;
    }

    public double getValor_total() {
        return valor_produtos + valor_frete - valor_desconto;
    }

}
