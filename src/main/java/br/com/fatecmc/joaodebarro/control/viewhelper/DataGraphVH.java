package br.com.fatecmc.joaodebarro.control.viewhelper;

import br.com.fatecmc.joaodebarro.control.data.JsonGenerator;
import br.com.fatecmc.joaodebarro.control.data.ConsultaGrafico;
import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ParameterParser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataGraphVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String a = request.getRequestURI();
        String b = request.getRequestURL().toString();
        
        ConsultaGrafico cg = new ConsultaGrafico();
        
        cg.setId(-1);
        cg.setDt_inicio(ParameterParser.toDate(request.getParameter("dt_inicio")));
        cg.setDt_fim(ParameterParser.toDate(request.getParameter("dt_fim")));
        cg.setGrafico(request.getParameter("grafico"));
        
        return cg;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        String json = new JsonGenerator().gerarJsonGraph((ConsultaGrafico) resultado).toString();
        
        response.setStatus(200);
        response.getWriter().write(json);
    }
    
}
