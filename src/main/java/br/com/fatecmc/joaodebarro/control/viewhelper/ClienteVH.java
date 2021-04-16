package br.com.fatecmc.joaodebarro.control.viewhelper;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ParameterParser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClienteVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        Cliente cliente = new Cliente();
        Usuario usuario = new Usuario();
        
        cliente.setId(ParameterParser.toInt(request.getParameter("cli_id")));
        usuario.setId(ParameterParser.toInt(request.getParameter("cli_usu_id")));
        cliente.setNome(request.getParameter("cli_nome"));
        cliente.setCpf(request.getParameter("cli_cpf"));
        cliente.setGenero(Genero.idToEnum(ParameterParser.toInt(request.getParameter("cli_gen_id"))));
        cliente.setTel_tipo(TipoTelefone.idToEnum(ParameterParser.toInt(request.getParameter("cli_tel_tte_id"))));
        cliente.setTel_ddd(request.getParameter("cli_tel_ddd"));
        cliente.setTel_numero(request.getParameter("cli_tel_numero"));
        cliente.setDt_nascimento(ParameterParser.toDate(request.getParameter("cli_dt_nascimento")));
        cliente.setStatus(ParameterParser.toBoolean(request.getParameter("cli_status")));
               
        cliente.setUsuario(usuario);
        return cliente;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        switch(request.getParameter("operacao")){
            case "ALTERAR":
                response.sendRedirect("/JoaoDeBarro/faces/cliente.jsp"); break;
            case "ALTERAR_STATUS":
                response.sendRedirect("/JoaoDeBarro/faces/admin.jsp"); break;
            case "VISUALIZAR":
                response.sendRedirect("/JoaoDeBarro/faces/admin.jsp"); break;
            default:
                response.sendRedirect("/JoaoDeBarro/faces/cliente.jsp?cli_id="+resultado);
        }
    }
    
}
