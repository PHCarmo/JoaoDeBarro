package br.com.fatecmc.joaodebarro.control;

import br.com.fatecmc.joaodebarro.control.command.*;
import br.com.fatecmc.joaodebarro.control.viewhelper.*;
import br.com.fatecmc.joaodebarro.model.domain.EntidadeDominio;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller", urlPatterns = {"/Cliente", "/Registrar", "/TableConstructor"})
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String operacao = null;
    private static Map<String, ICommand> cmds;
    private static Map<String, IViewHelper> vhs;
    
    public Controller() {
        super();
        cmds = new HashMap<>();
        cmds.put("SALVAR", new SalvarCommand());
        cmds.put("ALTERAR", new AlterarCommand());
        cmds.put("ALTERAR_STATUS", new AlterarCommand());
        cmds.put("EXCLUIR", new ExcluirCommand());	
        cmds.put("CONSULTAR", new ConsultarCommand());
        cmds.put("VISUALIZAR", new ConsultarCommand());
        cmds.put("GERAR_TABELA", new ConsultarCommand());
        
        vhs = new HashMap<>();
        vhs.put("/JoaoDeBarro/faces/Cliente", new ClienteVH());
        vhs.put("/JoaoDeBarro/faces/Registrar", new UsuarioVH());
        vhs.put("/JoaoDeBarro/faces/TableConstructor", new DataTableVH());
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        operacao = request.getParameter("operacao");
        
        String uri = request.getRequestURI();
        IViewHelper viewhelper = vhs.get(uri);
        EntidadeDominio entidade = viewhelper.getEntidade(request);

        ICommand command = cmds.get(operacao);
        Object message = command.execute(entidade);

        viewhelper.setView(message, request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet João De Barro - E-commerce";
    }

}
