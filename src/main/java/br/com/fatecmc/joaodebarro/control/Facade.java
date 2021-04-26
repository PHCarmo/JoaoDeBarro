package br.com.fatecmc.joaodebarro.control;

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
    }

    private void initStrategy() {
        rns = new HashMap<>();

        ValidarExistenciaAluno validar_existencia_aluno = new ValidarExistenciaAluno();
        
        List<IStrategy> rns_cliente = new ArrayList<>();
        rns_cliente.add(validar_existencia_aluno);
        
        List<IStrategy> rns_usuario = new ArrayList<>();
        
        rns.put(Cliente.class.getName(), rns_cliente);
        rns.put(Usuario.class.getName(), rns_usuario);
    }
    
    private String processStrategys(EntidadeDominio entidade) {
        List<IStrategy> regras = rns.get(entidade.getClass().getName());

        StringBuilder final_message = new StringBuilder();
        if (regras != null) {
            for (IStrategy strategy : regras) {
                String message = strategy.process(entidade);

                if(message != null) {
                    final_message.append(message);
                    final_message.append("\n");
                }
            }
        }

        return(final_message.length() > 0) ? final_message.toString() : null;
    }
    
    @Override
    public Object salvar(EntidadeDominio entidade) {
        String error_message = processStrategys(entidade);
        if (error_message == null) {
            IDAO dao = daos.get(entidade.getClass().getName());
            return dao.salvar(entidade);
        } else {
            return error_message;
        }
    }

    @Override
    public String alterar(EntidadeDominio entidade) {
        String error_message = processStrategys(entidade);
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
        String error_message = processStrategys(entidade);
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
        String error_message = processStrategys(entidade);
        if (error_message == null) {
            IDAO dao = daos.get(entidade.getClass().getName());
            int id = entidade.getId();
            if(id != 0)
                return dao.consultar(id);
            else
                return dao.consultar();
        } else {
            return error_message;
        }
    }
    
}
