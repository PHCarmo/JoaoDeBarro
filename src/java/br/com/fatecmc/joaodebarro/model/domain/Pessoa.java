package br.com.fatecmc.joaodebarro.model.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Pessoa extends EntidadeDominio {
    private Collection<Documento> documentos;

    public Pessoa() {
        super();
        this.documentos = new ArrayList<>();
    }

    public Pessoa(Collection<Documento> documentos) {
        super();
        this.documentos = documentos;
    }

    public Pessoa(Collection<Documento> documentos, int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.documentos = documentos;
    }

    public Collection<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Collection<Documento> documentos) {
        this.documentos = documentos;
    }
    
}
