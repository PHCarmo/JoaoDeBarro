package br.com.fatecmc.joaodebarro.model.strategy;

import br.com.fatecmc.joaodebarro.model.domain.EntidadeDominio;

public interface IStrategy {
    
    public String process(EntidadeDominio entidade);
    
}
