package br.com.fatecmc.joaodebarro.control.viewhelper;

import br.com.fatecmc.joaodebarro.control.data.JsonGenerator;
import br.com.fatecmc.joaodebarro.model.dao.PedidoDAO;
import br.com.fatecmc.joaodebarro.model.domain.*;
import java.io.IOException;
import java.util.Arrays;
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
        entidades.put("Venda", new Pedido());
        entidades.put("Compra", new Pedido());
        entidades.put("Carrinho", new Carrinho());
        entidades.put("Produto", new Produto());
    }

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        EntidadeDominio entidade = entidades.get(request.getParameter("tabela"));
        
        if(entidade instanceof Carrinho){
            if(request.getSession().getAttribute("car_id") == null) entidade.setId(-1);
            else entidade.setId((int) request.getSession().getAttribute("car_id"));
        }
        
        return entidade;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("tabela").equals("Compra")){
            Cliente cliente = new Cliente();
            cliente.setId((int) request.getSession().getAttribute("cli_id"));
            resultado = new PedidoDAO().consultarPorCliente(cliente);
        }
        if(!(resultado instanceof List)) resultado = Arrays.asList(resultado);
        
        String json = new JsonGenerator().gerarJsonTabela((List<EntidadeDominio>) resultado,
                request.getParameter("tabela"));
        
        response.setStatus(200);
        response.getWriter().write(json);
    }
    
}
