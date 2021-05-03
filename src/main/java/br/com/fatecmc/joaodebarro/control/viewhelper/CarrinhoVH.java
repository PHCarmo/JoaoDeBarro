package br.com.fatecmc.joaodebarro.control.viewhelper;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ParameterParser;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarrinhoVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        Cliente cliente = new Cliente();
        
        Object cli_id = request.getSession(false).getAttribute("cli_id");
        if(cli_id == null) cli_id = "-1";
        cliente.setId(ParameterParser.toInt(cli_id.toString()));
        
        return cliente;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        switch(request.getParameter("operacao")){
            case "CONSULTAR":
                request.setAttribute("cliente", resultado);
                request.getRequestDispatcher("carrinho.jsp").forward(request, response); break;
        }
    }
    
}
