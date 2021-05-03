package br.com.fatecmc.joaodebarro.control.viewhelper;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ParameterParser;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClienteVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        Cliente cliente = new Cliente();
        Usuario usuario = new Usuario();
        
        String cli_id = request.getParameter("cli_id") == null ?
                request.getSession(false).getAttribute("cli_id").toString() : request.getParameter("cli_id");
        cliente.setId(ParameterParser.toInt(cli_id));
        usuario.setId(ParameterParser.toInt(request.getParameter("cli_usu_id")));
        cliente.setNome(request.getParameter("cli_nome"));
        cliente.setCpf(request.getParameter("cli_cpf"));
        cliente.setGenero(Genero.idToEnum(ParameterParser.toInt(request.getParameter("cli_gen_id"))));
        cliente.setTel_tipo(TipoTelefone.idToEnum(ParameterParser.toInt(request.getParameter("cli_tel_tte_id"))));
        cliente.setTel_ddd(request.getParameter("cli_tel_ddd"));
        cliente.setTel_numero(request.getParameter("cli_tel_numero"));
        cliente.setDt_nascimento(ParameterParser.toDate(request.getParameter("cli_dt_nascimento")));
        cliente.setStatus(ParameterParser.toBoolean(request.getParameter("cli_status")));
        
        if(!request.getRequestURI().contains("cartao"))
            cliente.setEnderecos(Arrays.asList((Endereco)new EnderecoVH().getEntidade(request)));
        if(request.getRequestURI().contains("cartao"))
            cliente.setCartoes(Arrays.asList((Cartao)new CartaoVH().getEntidade(request)));
        cliente.setUsuario(usuario);
        return cliente;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        switch(request.getParameter("operacao")){
            case "ALTERAR":
                response.sendRedirect("/JoaoDeBarro/faces/cliente?operacao=CONSULTAR"); break;
            case "ALTERAR_STATUS":
                response.sendRedirect("/JoaoDeBarro/faces/admin.jsp"); break;
            case "VISUALIZAR":
                response.sendRedirect("/JoaoDeBarro/faces/admin.jsp"); break;
            case "CONSULTAR":
                request.setAttribute("cliente", resultado);
                request.getRequestDispatcher("cliente.jsp").forward(request, response); break;
            case "SALVAR":
                request.getSession().setAttribute("cli_id", ((Cliente)resultado).getId());
                response.sendRedirect("/JoaoDeBarro/faces/cliente?operacao=CONSULTAR"); break;
        }
    }
    
}
