package br.com.fatecmc.joaodebarro.control;

import br.com.fatecmc.joaodebarro.control.data.ConsultaGrafico;
import br.com.fatecmc.joaodebarro.model.dao.*;
import br.com.fatecmc.joaodebarro.model.strategy.*;
import br.com.fatecmc.joaodebarro.model.domain.*;
import java.util.*;

public class Facade implements IFacade {
    private Map<String, IDAO> daos;
    private Map<String, List<IStrategy>> rns;

    public Facade() {
        initDAO();
        initStrategy();
    }

    private void initDAO() {
        daos = new HashMap<>();
        daos.put(Cliente.class.getName(), new ClienteDAO());
        daos.put(Usuario.class.getName(), new UsuarioDAO());
        daos.put(Produto.class.getName(), new ProdutoDAO());
        daos.put(Carrinho.class.getName(), new ItemDAO());
        daos.put(Item.class.getName(), new ItemDAO());
        daos.put(Pedido.class.getName(), new PedidoDAO());
        daos.put(Cupom.class.getName(), new CupomDAO());
        daos.put(ConsultaGrafico.class.getName(), new GraficoDAO());
    }

    private void initStrategy() {
        rns = new HashMap<>();

        List<IStrategy> rns_pedido = new ArrayList<>();
        rns_pedido.add(new CamposObrigatoriosPedido());
        rns_pedido.add(new ValorPagoValidoPedido());
        rns_pedido.add(new ValorMinimoPagoCartao());
        rns_pedido.add(new QuantidadeProdutosValidaPedido());
        rns_pedido.add(new ValeTrocaDesnecessarioPedido());
        rns_pedido.add(new GerarCupomTroca());
        
        List<IStrategy> rns_usuario = new ArrayList<>();
        rns_usuario.add(new FormatoValidoSenhaUsuario());
        rns_usuario.add(new CriptografiaSenhaUsuario());
        
        rns.put("SALVAR" + Pedido.class.getName(), rns_pedido);
        rns.put("SALVAR" + Usuario.class.getName(), rns_usuario);
    }
    
    private String processStrategys(String operacao, EntidadeDominio entidade) {
        List<IStrategy> regras = rns.get(operacao + entidade.getClass().getName());

        StringBuilder final_message = new StringBuilder();
        if (regras != null) {
            for (IStrategy strategy : regras) {
                String message = strategy.process(entidade);

                if(message != null) {
                    if(final_message.length() > 0)
                        final_message.append("<br>");
                    final_message.append(message);
                }
            }
        }

        return(final_message.length() > 0) ? final_message.toString() : null;
    }
    
    @Override
    public Object salvar(EntidadeDominio entidade) {
        String error_message = processStrategys("SALVAR", entidade);
        if (error_message == null) {
            IDAO dao = daos.get(entidade.getClass().getName());
            return dao.salvar(entidade);
        } else {
            return error_message;
        }
    }

    @Override
    public String alterar(EntidadeDominio entidade) {
        String error_message = processStrategys("ALTERAR", entidade);
        if (error_message == null) {
            IDAO dao = daos.get(entidade.getClass().getName());
            dao.alterar(entidade);
            return null;
        } else {
            return error_message;
        }
    }

    @Override
    public String excluir(EntidadeDominio entidade) {
        String error_message = processStrategys("EXCLUIR", entidade);
        if (error_message == null) {
            IDAO dao = daos.get(entidade.getClass().getName());
            dao.excluir(entidade.getId());
            return null;
        } else {
            return error_message;
        }
    }

    @Override
    public Object consultar(EntidadeDominio entidade) {
        String error_message = processStrategys("CONSULTAR", entidade);
        if (error_message == null) {
            IDAO dao = daos.get(entidade.getClass().getName());
            if(entidade.getId() != 0)
                return dao.consultar(entidade);
            else
                return dao.consultar();
        } else {
            return error_message;
        }
    }
    
}
