package br.com.fatecmc.joaodebarro.control.viewhelper;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ParameterParser;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClienteVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        int id_cliente =    ParameterParser.toInt(request.getParameter("cli_id"));
        int id_usuario =    ParameterParser.toInt(request.getParameter("cli_usu_id"));
        String nome =       request.getParameter("cli_nome");
        String cpf =        request.getParameter("cli_cpf");
        int id_genero =     ParameterParser.toInt(request.getParameter("cli_gen_id"));
        int id_tel_tipo =   ParameterParser.toInt(request.getParameter("cli_tel_tte_id"));
        String tel_ddd =    request.getParameter("cli_tel_ddd");
        String tel_numero = request.getParameter("cli_tel_numero");
        Date dt_nasc =      ParameterParser.toDate(request.getParameter("cli_dt_nascimento"));
        boolean status =    ParameterParser.toBoolean(request.getParameter("cli_status"));
        //Collection<Endereco> enderecos;
        
        Usuario usuario = new Usuario("", "", null, id_usuario, null);
        Genero genero = new Genero("", id_genero, null);
        TipoTelefone tipo_tel = new TipoTelefone("", id_tel_tipo, null);
        Cliente cliente = new Cliente(usuario, nome, cpf, genero, tipo_tel, tel_ddd, tel_numero, dt_nasc, null, null, status, id_cliente, new Date());
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
