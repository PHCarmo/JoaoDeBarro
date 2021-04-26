package br.com.fatecmc.joaodebarro.control.viewhelper;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ParameterParser;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ItemVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        Produto produto = new Produto();
        produto.setId(ParameterParser.toInt(request.getParameter("prd_id")));
        
        Item item = new Item();
        item.setProduto(produto);
        item.setQtd(ParameterParser.toInt(request.getParameter("pcr_qtd")));
        
        Session session = new Session();
        session.setId(request.getSession().getId());
        session.setDt_criacao(new Date((long)request.getSession().getCreationTime()));
        
        Carrinho carrinho = new Carrinho();
        if(request.getSession().getAttribute("car_id") != null)
            carrinho.setId((int) request.getSession().getAttribute("car_id"));
        carrinho.setSession(session);
        carrinho.setItens(Arrays.asList(item));
        
        return carrinho;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("car_id", ((Carrinho) resultado).getId());
        response.sendRedirect("carrinho.jsp");
    }
    
}
