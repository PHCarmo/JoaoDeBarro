package br.com.fatecmc.joaodebarro.model.strategy;

import br.com.fatecmc.joaodebarro.model.domain.*;

public class CamposObrigatoriosPedido implements IStrategy{

    @Override
    public String process(EntidadeDominio entidade) {
        boolean validacao;
        
        Pedido p = (Pedido) entidade;
        validacao = p.getEnd_cobranca().getId() == 0
                || p.getEnd_entrega().getId() == 0;
                
        if(validacao)
            return "- Escolha um endereço para cobrança e outro para entrega.";
        
        return null;
    }
    
}
