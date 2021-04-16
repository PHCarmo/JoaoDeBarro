package br.com.fatecmc.joaodebarro.model.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Cliente extends EntidadeDominio {
    private Usuario usuario;
    private String codigo;
    private String nome;
    private String cpf;
    private Genero genero;
    private TipoTelefone tel_tipo;
    private String tel_ddd;
    private String tel_numero;
    private Date dt_nascimento;
    private Collection<Endereco> enderecos;
    private Collection<Cartao> cartoes;
    private Collection<ValeTroca> vales;
    private boolean status;

    public Cliente() {
        super();
        this.usuario = new Usuario();
        this.codigo = "";
        this.nome = "";
        this.cpf = "";
        this.genero = null;
        this.tel_tipo = null;
        this.tel_ddd = "";
        this.tel_numero = "";
        this.dt_nascimento = new Date();
        this.enderecos = new ArrayList<>();
        this.cartoes = new ArrayList<>();
        this.vales = new ArrayList<>();
        this.status = false;
    }

    public Cliente(Usuario usuario, String codigo, String nome, String cpf,
            Genero genero, TipoTelefone tel_tipo, String tel_ddd,
            String tel_numero, Date dt_nascimento, Collection<Endereco> enderecos,
            Collection<Cartao> cartoes, Collection<ValeTroca> vales, boolean status) {
        super();
        this.usuario = usuario;
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero;
        this.tel_tipo = tel_tipo;
        this.tel_ddd = tel_ddd;
        this.tel_numero = tel_numero;
        this.dt_nascimento = dt_nascimento;
        this.enderecos = enderecos;
        this.cartoes = cartoes;
        this.vales = vales;
        this.status = status;
    }

    public Cliente(Usuario usuario, String codigo, String nome, String cpf,
            Genero genero, TipoTelefone tel_tipo, String tel_ddd,
            String tel_numero, Date dt_nascimento, Collection<Endereco> enderecos,
            Collection<Cartao> cartoes, Collection<ValeTroca> vales, boolean status,
            int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.usuario = usuario;
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero;
        this.tel_tipo = tel_tipo;
        this.tel_ddd = tel_ddd;
        this.tel_numero = tel_numero;
        this.dt_nascimento = dt_nascimento;
        this.enderecos = enderecos;
        this.cartoes = cartoes;
        this.vales = vales;
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public TipoTelefone getTel_tipo() {
        return tel_tipo;
    }

    public void setTel_tipo(TipoTelefone tel_tipo) {
        this.tel_tipo = tel_tipo;
    }

    public String getTel_ddd() {
        return tel_ddd;
    }

    public void setTel_ddd(String tel_ddd) {
        this.tel_ddd = tel_ddd;
    }

    public String getTel_numero() {
        return tel_numero;
    }

    public void setTel_numero(String tel_numero) {
        this.tel_numero = tel_numero;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public Collection<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Collection<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Collection<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(Collection<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    public Collection<ValeTroca> getVales() {
        return vales;
    }

    public void setVales(Collection<ValeTroca> vales) {
        this.vales = vales;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
