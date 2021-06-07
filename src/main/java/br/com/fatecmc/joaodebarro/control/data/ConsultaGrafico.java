package br.com.fatecmc.joaodebarro.control.data;

import br.com.fatecmc.joaodebarro.model.domain.*;
import java.util.*;

public class ConsultaGrafico extends EntidadeDominio {
    private List<Object[]> data;
    private Date dt_inicio;
    private Date dt_fim;
    private String grafico;

    public ConsultaGrafico() {
        super();
        this.data = new ArrayList<>();
        this.dt_inicio = new Date();
        this.dt_fim = new Date();
        this.grafico = "";
    }

    public ConsultaGrafico(List<Object[]> data, Date dt_inicio, Date dt_fim, String grafico) {
        super();
        this.data = data;
        this.dt_inicio = dt_inicio;
        this.dt_fim = dt_fim;
        this.grafico = grafico;
    }

    public ConsultaGrafico(List<Object[]> data, Date dt_inicio, Date dt_fim, String grafico,
            int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.data = data;
        this.dt_inicio = dt_inicio;
        this.dt_fim = dt_fim;
        this.grafico = grafico;
    }

    public List<Object[]> getData() {
        return data;
    }

    public void setData(List<Object[]> data) {
        this.data = data;
    }

    public Date getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(Date dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public Date getDt_fim() {
        return dt_fim;
    }

    public void setDt_fim(Date dt_fim) {
        this.dt_fim = dt_fim;
    }

    public String getGrafico() {
        return grafico;
    }

    public void setGrafico(String grafico) {
        this.grafico = grafico;
    }
    
}
