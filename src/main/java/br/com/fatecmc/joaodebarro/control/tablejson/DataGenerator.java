package br.com.fatecmc.joaodebarro.control.tablejson;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.Mask;
import java.util.List;
import org.json.JSONArray;

public class DataGenerator {

    public JSONArray getClienteData(List<EntidadeDominio> entidades) {
        JSONArray data = new JSONArray();
        
        for (EntidadeDominio e : entidades) {
            Cliente c = (Cliente) e;
            JSONArray obj = new JSONArray();
            
            obj.put("<div class='circle " + (c.getStatus() ? "green" : "grey") + "'></div>");
            obj.put(c.getCodigo());
            obj.put(c.getUsuario().getId());
            obj.put(c.getNome());
            obj.put(Mask.toCPF(c.getCpf()));
            obj.put("<a class='btn btn-default' title='Ativar/Inativar' href='#'><img class='icon' src='icon/eye.png' /></a>"
                    + "<a class='btn btn-default' title='Historico de Transacoes' href='#'><img class='icon' src='icon/history.png' /></a>");
            
            data.put(obj);
        }
        
        return data;
    }

}
