package br.com.fatecmc.joaodebarro.control.data;

import br.com.fatecmc.joaodebarro.control.data.table.IDataCommand;
import br.com.fatecmc.joaodebarro.control.data.table.*;
import br.com.fatecmc.joaodebarro.model.domain.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.*;

public class JsonGenerator {
    private static Map<String, IDataCommand> table_cmds;

    public JsonGenerator() {
        table_cmds = new HashMap<>();
        
        //Table Commands
        table_cmds.put("Cliente", new ClienteDataCommand());
        table_cmds.put("Venda", new VendaDataCommand());
        table_cmds.put("Compra", new CompraDataCommand());
        table_cmds.put("Carrinho", new CarrinhoDataCommand());
        table_cmds.put("Produto", new ProdutoDataCommand());
    }

    public String gerarJsonTabela(List<EntidadeDominio> entidades, String table) {
        if (entidades.isEmpty()) {
            return new JSONObject().put("data", new JSONArray()).toString();
        } else {
            return new JSONObject().put("draw", 1)
                    .put("recordsTotal", entidades.size())
                    .put("recordsFiltered", entidades.size())
                    .put("data", table_cmds.get(table).execute(entidades)).toString();
        }
    }

}
