package br.com.fatecmc.joaodebarro.control.command;

import br.com.fatecmc.joaodebarro.model.domain.EntidadeDominio;

public class VisualizarCommand extends AbstractCommand {
    
    @Override
    public Object execute(EntidadeDominio entidade) {		
        return facade.visualizar(entidade);
    }
    
}
