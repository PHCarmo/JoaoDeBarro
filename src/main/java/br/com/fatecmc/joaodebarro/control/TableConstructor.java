package br.com.fatecmc.joaodebarro.control;

import br.com.fatecmc.joaodebarro.control.tablejson.*;
import br.com.fatecmc.joaodebarro.control.command.ConsultarCommand;
import br.com.fatecmc.joaodebarro.model.domain.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TableConstructor", urlPatterns = {"/TableConstructor"})
public class TableConstructor extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Map<String, EntidadeDominio> entitys;
    private static Map<String, IGeneratorJson> generators;
       
    public TableConstructor() {
        super();
        entitys = new HashMap<>();
        entitys.put("Cliente", new Cliente());
        
        generators = new HashMap<>();
        generators.put("Cliente", new GeneratorJsonCliente());
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tabela = request.getParameter("tabela");
        List<EntidadeDominio> entidades = (List<EntidadeDominio>) 
                new ConsultarCommand().execute(entitys.get(tabela));
        String json = generators.get(tabela).gerar(entidades);
        
        response.setStatus(200);
        response.getWriter().write(json);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        processRequest(request, response);
    }
	
}
