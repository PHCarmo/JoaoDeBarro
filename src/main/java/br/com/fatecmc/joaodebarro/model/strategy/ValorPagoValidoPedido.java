package br.com.fatecmc.joaodebarro.model.strategy;

import br.com.fatecmc.joaodebarro.model.domain.*;

public class ValorPagoValidoPedido implements IStrategy{

    @Override
    public String process(EntidadeDominio entidade) {
        boolean validacao = false;
        
        Pedido p = (Pedido) entidade;
        if(p.getValor_total() > 0) validacao = p.getValor_total() != p.getValor_pago();
                
        if(validacao)
            return "- Valor total pago diverge do valor total comprado.";
        
        return null;
    }
    
}
