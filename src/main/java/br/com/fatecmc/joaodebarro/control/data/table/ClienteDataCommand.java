package br.com.fatecmc.joaodebarro.control.data.table;

import br.com.fatecmc.joaodebarro.model.domain.EntidadeDominio;
import java.util.List;

public class ClienteDataCommand extends AbstractDataCommand {
    
    @Override
    public Object execute(List<EntidadeDominio> entidades) {		
        return generator.getClienteData(entidades);
    }
    
}
