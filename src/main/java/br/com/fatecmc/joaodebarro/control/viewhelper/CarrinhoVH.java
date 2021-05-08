package br.com.fatecmc.joaodebarro.control.viewhelper;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ParameterParser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarrinhoVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        if(request.getAttribute("carrinho") == null){
            Carrinho carrinho = new Carrinho();
        
            Object car_id = request.getSession().getAttribute("car_id");
            if(car_id == null) car_id = "-1";
            carrinho.setId(ParameterParser.toInt(car_id.toString()));

            return carrinho;            
        }else if(request.getAttribute("cupons") == null){
            return new Cupom();            
        }else{
            Cliente cliente = new Cliente();
        
            Object cli_id = request.getSession().getAttribute("cli_id");
            if(cli_id == null) cli_id = "-1";
            cliente.setId(ParameterParser.toInt(cli_id.toString()));
            
            return cliente;
        }
    }
    
    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        if(request.getAttribute("carrinho") == null){
            request.setAttribute("carrinho", resultado);
            request.getRequestDispatcher("/carrinho?operacao=CONSULTAR").forward(request, response);       
        }else if(request.getAttribute("cupons") == null){
            request.setAttribute("cupons", resultado);
            request.getRequestDispatcher("/carrinho?operacao=CONSULTAR").forward(request, response);       
        }else{
            request.setAttribute("cliente", resultado);
            request.getRequestDispatcher("carrinho.jsp").forward(request, response);
        }
    }
    
}
