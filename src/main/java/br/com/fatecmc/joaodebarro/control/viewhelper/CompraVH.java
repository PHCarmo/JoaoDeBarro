package br.com.fatecmc.joaodebarro.control.viewhelper;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ParameterParser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompraVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        Pedido pedido = new Pedido();
        
        pedido.setId(ParameterParser.toInt(request.getParameter("ped_id")));
        pedido.setStatus(StatusPedido.idToEnum(ParameterParser.toInt(request.getParameter("ped_spd_id"))));
        
        return pedido;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("operacao").equals("ALTERAR")){
            response.sendRedirect("./cliente?operacao=CONSULTAR");
        }
    }
    
}
