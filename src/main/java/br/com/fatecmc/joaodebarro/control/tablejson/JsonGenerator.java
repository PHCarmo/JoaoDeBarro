package br.com.fatecmc.joaodebarro.control.tablejson;

import br.com.fatecmc.joaodebarro.model.domain.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.*;

public class JsonGenerator {
    private static Map<String, IDataCommand> cmds;

    public JsonGenerator() {
        cmds = new HashMap<>();
        cmds.put("Cliente", new ClienteDataCommand());
    }

    public String gerar(List<EntidadeDominio> entidades, String table) {
        if (entidades.isEmpty()) {
            return new JSONObject().put("data", new JSONArray()).toString();
        } else {
            return new JSONObject().put("draw", 1)
                    .put("recordsTotal", entidades.size())
                    .put("recordsFiltered", entidades.size())
                    .put("data", cmds.get(table).execute(entidades)).toString();
        }
    }

}
