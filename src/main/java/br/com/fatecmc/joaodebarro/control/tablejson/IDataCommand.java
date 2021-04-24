package br.com.fatecmc.joaodebarro.control.tablejson;

import br.com.fatecmc.joaodebarro.model.domain.EntidadeDominio;
import java.util.List;

public interface IDataCommand {
    
    public Object execute(List<EntidadeDominio> entidades);
    
}
