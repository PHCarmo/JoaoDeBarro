package br.com.fatecmc.joaodebarro.model.strategy;

import br.com.fatecmc.joaodebarro.model.domain.*;

public class GerarCupomTroca implements IStrategy{

    @Override
    public String process(EntidadeDominio entidade) {
        
        Pedido p = (Pedido) entidade;
        if(p.getValor_total() < 0.0){
            ValeTroca vt = new ValeTroca();
            vt.setValor(Math.abs(p.getValor_total()));
            ((Pedido) entidade).getCliente().getVales().add(vt);
        }
        
        return null;
    }
    
}
