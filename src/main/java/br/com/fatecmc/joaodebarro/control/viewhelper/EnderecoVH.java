package br.com.fatecmc.joaodebarro.control.viewhelper;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ParameterParser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EnderecoVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        Endereco endereco = new Endereco();
        
        endereco.setApelido(request.getParameter("end_nome"));
        endereco.setCep(request.getParameter("end_cep"));
        endereco.setBairro(request.getParameter("end_bairro"));
        endereco.setTipo_log(TipoLogradouro.idToEnum(ParameterParser.toInt(request.getParameter("end_tlo_id"))));
        endereco.setLogradouro(request.getParameter("end_logradouro"));
        endereco.setNumero(request.getParameter("end_numero"));
        endereco.setTipo_res(TipoResidencia.idToEnum(ParameterParser.toInt(request.getParameter("end_tre_id"))));
        endereco.setCidade(request.getParameter("end_cidade"));
        endereco.setEstado(request.getParameter("end_estado"));
        endereco.setPais(request.getParameter("end_pais"));
        endereco.setTipo(TipoEndereco.idToEnum(ParameterParser.toInt(request.getParameter("end_ten_id"))));
        endereco.setObservacao(request.getParameter("end_observacao"));
        PropositoEndereco pe = PropositoEndereco.idToEnum(ParameterParser.toInt(request.getParameter("end_proposito")));
        if(pe!=null){
            endereco.setEntrega(pe.getEntrega());
            endereco.setCobranca(pe.getCobranca());
        }
        String cli_id = request.getParameter("cli_id") == null ?
                request.getSession(false).getAttribute("cli_id").toString() : request.getParameter("cli_id");
        endereco.setCliente_id(ParameterParser.toInt(cli_id));
        
        return endereco;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
    }
    
}
