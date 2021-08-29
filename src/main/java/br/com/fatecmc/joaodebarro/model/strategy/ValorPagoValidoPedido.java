package br.com.fatecmc.joaodebarro.model.strategy;

import br.com.fatecmc.joaodebarro.model.domain.*;

public class ValorPagoValidoPedido implements IStrategy{

    @Override
    public String process(EntidadeDominio entidade) {
        
        Pedido p = (Pedido) entidade;
        if(p.getValor_pago() > 0 && p.getValor_total() <= 0)
            return "- Não se paga compra gratuita!";            
        else if(p.getValor_total() > 0 && p.getValor_total() != p.getValor_pago())
            return "- Valor total pago diverge do valor total comprado.";
        
        return null;
    }
    
}
