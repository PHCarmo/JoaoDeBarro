package br.com.fatecmc.joaodebarro.control.viewhelper;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ParameterParser;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartaoVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        Cartao cartao = new Cartao();
        
        cartao.setNumero(request.getParameter("crt_numero"));
        cartao.setNome(request.getParameter("crt_nome"));
               
        int mes = ParameterParser.toInt(request.getParameter("crt_mes_validade"));
        int ano = ParameterParser.toInt(request.getParameter("crt_ano_validade"));
        cartao.setValidade(Date.from(LocalDate.of(ano, mes, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        
        cartao.setCvv(request.getParameter("crt_cvv"));
        cartao.setBandeira(BandeiraCartao.idToEnum(ParameterParser.toInt(request.getParameter("crt_bnd_id"))));
        
        return cartao;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
    }
    
}
