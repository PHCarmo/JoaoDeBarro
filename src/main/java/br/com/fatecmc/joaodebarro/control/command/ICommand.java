package br.com.fatecmc.joaodebarro.control.command;

import br.com.fatecmc.joaodebarro.model.domain.EntidadeDominio;

public interface ICommand {
    
    public Object execute(EntidadeDominio entidade);
    
}
