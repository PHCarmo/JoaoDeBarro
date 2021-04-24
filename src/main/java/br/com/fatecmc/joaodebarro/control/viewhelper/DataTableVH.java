package br.com.fatecmc.joaodebarro.control.viewhelper;

import br.com.fatecmc.joaodebarro.control.tablejson.JsonGenerator;
import br.com.fatecmc.joaodebarro.model.domain.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataTableVH implements IViewHelper {
    private static Map<String, EntidadeDominio> entidades;
    
    public DataTableVH() {
        entidades = new HashMap<>();
        entidades.put("Cliente", new Cliente());
    }

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        return entidades.get(request.getParameter("tabela"));
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        String json = new JsonGenerator().gerar((List<EntidadeDominio>) resultado,
                request.getParameter("tabela"));
        
        response.setStatus(200);
        response.getWriter().write(json);
    }
    
}
