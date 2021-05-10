package br.com.fatecmc.joaodebarro.control.viewhelper;

import br.com.fatecmc.joaodebarro.model.dao.CarrinhoDAO;
import br.com.fatecmc.joaodebarro.model.dao.ItemDAO;
import br.com.fatecmc.joaodebarro.model.dao.ProdutoDAO;
import br.com.fatecmc.joaodebarro.model.dao.ValeTrocaDAO;
import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ParameterParser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TrocaVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        Pedido pedido = new Pedido();
        Carrinho carrinho = new Carrinho();
        
        pedido.setId(ParameterParser.toInt(request.getParameter("ped_id")));
        pedido.setStatus(StatusPedido.TROCA_AUTORIZADA);
        
        if(request.getParameterValues("item") != null){
            pedido.setStatus(StatusPedido.EM_TROCA);
            carrinho.setId(ParameterParser.toInt(request.getParameter("car_id")));
            
            for(String value: request.getParameterValues("item")){
                Item item = new Item();
                item.setId(Integer.parseInt(value.split("|")[0]));
                item.setQtd(Integer.parseInt(value.split("|")[2]));
                item.setStatus(true);
                item.setTroca(true);
                carrinho.getItens().add(item);
            }
        }
        
        pedido.setCarrinho(carrinho);
        
        if(request.getParameter("operacao").equals("CONSULTAR")){
            carrinho.setId(ParameterParser.toInt(request.getParameter("car_id")));
            return carrinho;
        }else{
            return pedido;
        }
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("operacao").equals("CONSULTAR")){
            request.setAttribute("itens", resultado);
            request.getRequestDispatcher("form_troca.jsp").forward(request, response);
        }else if(request.getParameterValues("item") != null){
            response.sendRedirect("./cliente?operacao=CONSULTAR");
        }else{
            Carrinho carrinho = (Carrinho) new ItemDAO().consultarTrocados(ParameterParser.toInt(request.getParameter("car_id")));
            ValeTroca vt = new ValeTroca();
            vt.setValor(carrinho.getValor_total());
            Cliente cliente = new Cliente();
            cliente.setId(ParameterParser.toInt(request.getSession().getAttribute("cli_id")));
            cliente.getVales().add(vt);
            new ValeTrocaDAO().salvar(cliente);
            
            for(Item item: carrinho.getItens()){
                Produto prod = item.getProduto();
                prod.setQtd_estoque(prod.getQtd_estoque() + item.getQtd());
                new ProdutoDAO().alterarQtdEstoque(prod);
            }
            
            response.sendRedirect("admin.jsp");
        }
    }
    
}
