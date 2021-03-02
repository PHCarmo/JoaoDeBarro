package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class Usuario extends EntidadeDominio {
    private String email;
    private String senha;
    private TipoUsuario tipo;

    public Usuario() {
        super();
        this.email = "";
        this.senha = "";
        this.tipo = new TipoUsuario();
    }

    public Usuario(String email, String senha, TipoUsuario tipo) {
        super();
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Usuario(String email, String senha, TipoUsuario tipo, int id,
            Date dt_cadastro) {
        super(id, dt_cadastro);
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }
    
}
