package br.com.fatecmc.joaodebarro.model.strategy;

import br.com.fatecmc.joaodebarro.model.domain.*;

public class ValeTrocaDesnecessarioPedido implements IStrategy{

    @Override
    public String process(EntidadeDominio entidade) {
        boolean validacao = false;
        
        Pedido p = (Pedido) entidade;
        if(p.getValor_total() > 0.0){
            for(ValeTroca vt: p.getVales()){
                if(vt.getValor() < Math.abs(p.getValor_total())){
                    validacao = true;
                    break;
                }
            }
        }
        
        if(validacao)
            return "- Não adicione vales-troca de forma desnecessária após já ter ultrapassado o valor total.";
        
        return null;
    }
    
}
