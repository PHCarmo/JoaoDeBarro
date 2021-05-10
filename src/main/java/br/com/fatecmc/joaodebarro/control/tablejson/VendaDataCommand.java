package br.com.fatecmc.joaodebarro.control.tablejson;

import br.com.fatecmc.joaodebarro.model.domain.EntidadeDominio;
import java.util.List;

public class VendaDataCommand extends AbstractDataCommand {
    
    @Override
    public Object execute(List<EntidadeDominio> entidades) {		
        return generator.getVendaData(entidades);
    }
    
}
