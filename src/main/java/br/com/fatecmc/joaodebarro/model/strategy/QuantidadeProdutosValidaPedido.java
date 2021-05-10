package br.com.fatecmc.joaodebarro.model.strategy;

import br.com.fatecmc.joaodebarro.model.domain.*;

public class QuantidadeProdutosValidaPedido implements IStrategy{

    @Override
    public String process(EntidadeDominio entidade) {
        boolean validacao;
        
        Pedido p = (Pedido) entidade;
        validacao = p.getValor_produtos() == 0.0;
                
        if(validacao)
            return "- Adicione produtos ao carrinho antes de finalizar a compra.";
        
        return null;
    }
    
}
