package br.com.fatecmc.joaodebarro.model.strategy;

import br.com.fatecmc.joaodebarro.model.domain.*;

public class ValorMinimoPagoCartao implements IStrategy{

    @Override
    public String process(EntidadeDominio entidade) {
        boolean validacao = false;
        
        Pedido p = (Pedido) entidade;
        if(p.getValor_total() >= 10.0){
            for(Pagamento pgm: p.getPagamentos()){
                if(pgm.getValor() < 10.0){
                    validacao = true;
                    break;
                }
            }
        }
        
        if(validacao)
            return "- Deve ser pago no mínimo R$10,00 com cada cartão.";
        
        return null;
    }
    
}
