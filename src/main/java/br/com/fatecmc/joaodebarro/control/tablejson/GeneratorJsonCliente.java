package br.com.fatecmc.joaodebarro.control.tablejson;

import br.com.fatecmc.joaodebarro.model.domain.*;
import java.util.List;

public class GeneratorJsonCliente implements IGeneratorJson {

    @Override
    public String gerar(List<EntidadeDominio> entidades) {
        String json = "{\"data\":[]}";
        String data = "";
        if(!(entidades.isEmpty())) {
            int totalLista = entidades.size();
            int cont = 1;
            for(EntidadeDominio e: entidades) {
                Cliente a = (Cliente) e;
                data += " ["
                    +"\"<div style='width: 20px;height: 20px;border-radius: 50%;background-color:"+ (a.getStatus() ? "green" : "grey") + ";'></div>\","
                    +"\""+ a.getId() + "\","
                    +"\""+ a.getUsuario().getId() + "\","
                    +"\""+ a.getNome()+ "\","
                    +"\""+ a.getCpf() + "\","
                    +"\"<a href='./form_cliente.jsp"
                    +"?cli_usu_id=" + a.getUsuario().getId()
                    +"&cli_nome="+ a.getNome()
                    +"&cli_cpf="+ a.getCpf()
                    +"&cli_gen_id="+ a.getGenero().getId()
                    +"&cli_tel_tte_id="+ a.getTel_tipo().getId()
                    +"&cli_tel_ddd="+ a.getTel_ddd()
                    +"&cli_tel_numero="+ a.getTel_numero()
                    +"&cli_dt_nascimento="+ a.getDt_nascimento()
                    +"&cli_id="+ a.getId()
                    +"&operacao=VISUALIZAR"
                    +"'>O</a>\","
                    +"\"<a href='./Cliente?operacao=ALTERAR_STATUS"
                    +"&cli_id="+ a.getId()
                    +"&cli_status="+ a.getStatus()
                    +"'>O</a>\""
                    +"]";
                if(cont < totalLista){
                    data += ",";
                }
                cont++;
            }
            json = "{"
                + "  \"draw\": 1,"
                + "  \"recordsTotal\": "+ entidades.size() +","
                + "  \"recordsFiltered\": "+ entidades.size() +","
                + "  \"data\": ["+
                data +
                "]"+
                "}";
        }
        return json;
    }

}