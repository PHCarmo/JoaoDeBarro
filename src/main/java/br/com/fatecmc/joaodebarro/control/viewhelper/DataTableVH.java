package br.com.fatecmc.joaodebarro.control.viewhelper;

import br.com.fatecmc.joaodebarro.control.tablejson.GeneratorJsonCliente;
import br.com.fatecmc.joaodebarro.control.tablejson.IGeneratorJson;
import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ParameterParser;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
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
        String tabela = request.getParameter("tabela");
        
        DataTable data_table = new DataTable(tabela, null);
        return data_table;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        String json = generators.get(((DataTable) resultado).getNome()).gerar(((DataTable) resultado).getElementos());
        
        response.setStatus(200);
        response.getWriter().write(json);
    }
    
}
