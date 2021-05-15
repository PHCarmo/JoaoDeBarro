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
        item.setId(ParameterParser.toInt(request.getParameter("pcr_id")));
        item.setProduto(produto);
        item.setQtd(ParameterParser.toInt(request.getParameter("pcr_qtd")));

        Session session = new Session();
        session.setId(request.getSession().getId());
        session.setDt_criacao(new Date((long) request.getSession().getCreationTime()));

        Carrinho carrinho = new Carrinho();
        if (request.getSession().getAttribute("car_id") != null)
            carrinho.setId((int) request.getSession().getAttribute("car_id"));
        carrinho.setSession(session);
        carrinho.setItens(Arrays.asList(item));
        
        switch (request.getParameter("operacao")) {
            case "CONSULTAR":
                return produto;
            case "EXCLUIR":
                return item;
            default:
                return carrinho;
        }
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("operacao").equals("SALVAR"))
            request.getSession().setAttribute("car_id", ((Carrinho) resultado).getId());        
        if (request.getParameter("operacao").equals("CONSULTAR")){
            request.setAttribute("produto", resultado);
            request.getRequestDispatcher("detalhe_produto.jsp").forward(request, response);
        } else {
            response.sendRedirect("./carrinho?operacao=CONSULTAR");
        }
    }

}
