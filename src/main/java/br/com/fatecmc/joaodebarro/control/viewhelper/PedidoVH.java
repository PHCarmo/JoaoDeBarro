package br.com.fatecmc.joaodebarro.control.viewhelper;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ParameterParser;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PedidoVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        Pedido pedido = new Pedido();
        Carrinho carrinho = new Carrinho();
        Cliente cliente = new Cliente();
        Endereco entrega = new Endereco();
        Endereco cobranca = new Endereco();
        Cupom cupom = new Cupom();
        
        carrinho.setId(ParameterParser.toInt(request.getSession(false).getAttribute("car_id")));
        cliente.setId(ParameterParser.toInt(request.getSession(false).getAttribute("cli_id")));
        entrega.setId(ParameterParser.toInt(request.getParameter("entrega")));
        cobranca.setId(ParameterParser.toInt(request.getParameter("cobranca")));
        cupom.setId(ParameterParser.toInt(request.getParameter("cpm_id")));
        pedido.setCarrinho(carrinho);
        pedido.setCliente(cliente);
        pedido.setEnd_entrega(entrega);
        pedido.setEnd_cobranca(cobranca);
        pedido.setCupom(cupom);
        pedido.setValor_frete(10.0);
        pedido.setValor_desconto(0);
        pedido.setValor_produtos(0);
        
        if(request.getParameterValues("vt") != null)
        for(String value: request.getParameterValues("vt")){
            ValeTroca vt = new ValeTroca();
            vt.setId(Integer.parseInt(value));
            pedido.getVales().add(vt);
        }
        
        Enumeration<String> params = request.getParameterNames();
        while(params.hasMoreElements()) {
            String name = params.nextElement();
            if(name.contains("crt") && !request.getParameter(name).equals("")){
                Pagamento pgm = new Pagamento();
                Cartao cartao = new Cartao();
                
                cartao.setId(Integer.parseInt(name.replace("crt", "")));
                pgm.setValor(ParameterParser.toDouble(request.getParameter(name)));
                pgm.setCartao(cartao);
                
                pedido.getPagamentos().add(pgm);
            }
        }
        
        return pedido;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        if(resultado instanceof String){
            request.setAttribute("Error", resultado);
            request.getRequestDispatcher("carrinho?operacao=CONSULTAR").forward(request, response);
        }else{
            response.sendRedirect("./cliente?operacao=CONSULTAR");
        }
    }
    
}
