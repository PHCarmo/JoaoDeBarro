package br.com.fatecmc.joaodebarro.control.viewhelper;

import br.com.fatecmc.joaodebarro.model.domain.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        Usuario usuario = new Usuario();
        
        usuario.setEmail(request.getParameter("usu_si_email"));
        usuario.setSenha(request.getParameter("usu_si_senha"));
        
        return usuario;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/JoaoDeBarro/faces/form_cliente.jsp?cli_usu_id="+((Usuario)resultado).getId());
    }
    
}
