package br.com.fatecmc.joaodebarro.control;

import br.com.fatecmc.joaodebarro.control.command.*;
import br.com.fatecmc.joaodebarro.control.service.ValidarPedidos;
import br.com.fatecmc.joaodebarro.control.viewhelper.*;
import br.com.fatecmc.joaodebarro.model.domain.EntidadeDominio;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller",
        urlPatterns = {"/cliente", "/Registrar", "/TableConstructor", "/GraphConstructor",
            "/produto", "/item", "/endereco", "/cartao", "/carrinho", "/pedido",
            "/venda", "/compra", "/trocar", "/trocado", "/usuario"})
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String operacao = null;
    private static Map<String, ICommand> cmds;
    private static Map<String, IViewHelper> vhs;
    private static Timer rotinas;
    
    public Controller() {
        super();
        initCommands();        
        initViewHelpers();
        initServices();
    }
    
    private void initCommands(){
        cmds = new HashMap<>();
        cmds.put("SALVAR", new SalvarCommand());
        cmds.put("ALTERAR", new AlterarCommand());
        cmds.put("EXCLUIR", new ExcluirCommand());
        cmds.put("CONSULTAR", new ConsultarCommand());
        cmds.put("VISUALIZAR", new ConsultarCommand());
        cmds.put("GERAR_TABELA", new ConsultarCommand());
        cmds.put("GERAR_GRAFICO", new ConsultarCommand());
    }
    
    private void initViewHelpers(){
        vhs = new HashMap<>();
        vhs.put("/JoaoDeBarro/faces/cliente", new ClienteVH());
        vhs.put("/JoaoDeBarro/faces/endereco", new ClienteVH());
        vhs.put("/JoaoDeBarro/faces/cartao", new ClienteVH());
        vhs.put("/JoaoDeBarro/faces/Registrar", new UsuarioVH());
        vhs.put("/JoaoDeBarro/faces/TableConstructor", new DataTableVH());
        vhs.put("/JoaoDeBarro/faces/GraphConstructor", new DataGraphVH());
        vhs.put("/JoaoDeBarro/faces/produto", new ProdutoVH());
        vhs.put("/JoaoDeBarro/faces/item", new ItemVH());
        vhs.put("/JoaoDeBarro/faces/carrinho", new CarrinhoVH());
        vhs.put("/JoaoDeBarro/faces/pedido", new PedidoVH());
        vhs.put("/JoaoDeBarro/faces/venda", new VendaVH());
        vhs.put("/JoaoDeBarro/faces/compra", new CompraVH());
        vhs.put("/JoaoDeBarro/faces/trocar", new TrocaVH());
        vhs.put("/JoaoDeBarro/faces/trocado", new TrocaVH());
        vhs.put("/JoaoDeBarro/faces/usuario", new UsuarioVH());
    }
    
    private void initServices(){
        rotinas = new Timer();
        //Valida pedidos a cada 3 minutos
        rotinas.schedule(new ValidarPedidos(), 0, 3 * 60 * 1000);
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
