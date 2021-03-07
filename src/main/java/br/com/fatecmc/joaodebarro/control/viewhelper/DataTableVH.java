package br.com.fatecmc.joaodebarro.control.viewhelper;

import br.com.fatecmc.joaodebarro.control.tablejson.GeneratorJsonCliente;
import br.com.fatecmc.joaodebarro.control.tablejson.IGeneratorJson;
import br.com.fatecmc.joaodebarro.model.domain.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataTableVH implements IViewHelper {
    private static Map<String, IGeneratorJson> generators;
    
    public DataTableVH() {
        generators = new HashMap<>();
        generators.put("Cliente", new GeneratorJsonCliente());
    }

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        return new Cliente();
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        String json = generators.get(request.getParameter("tabela")).gerar((List<EntidadeDominio>) resultado);
        
        response.setStatus(200);
        response.getWriter().write(json);
    }
    
}
