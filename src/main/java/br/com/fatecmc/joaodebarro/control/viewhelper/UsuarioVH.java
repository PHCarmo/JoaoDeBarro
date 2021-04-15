package br.com.fatecmc.joaodebarro.control.viewhelper;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ParameterParser;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String email =       request.getParameter("usu_si_email");
        String senha =       request.getParameter("usu_si_senha");
        
        Usuario usuario = new Usuario(email, senha, TipoUsuario.CLIENTE, 0, new Date());
        return usuario;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/JoaoDeBarro/faces/form_cliente.jsp?cli_usu_id="+resultado);
    }
    
}
