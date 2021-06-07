package br.com.fatecmc.joaodebarro.model.dao;

import br.com.fatecmc.joaodebarro.model.domain.EntidadeDominio;
import java.util.List;

public interface IDAO {
    
    public EntidadeDominio salvar(EntidadeDominio entidade);
    public boolean alterar(EntidadeDominio entidade);
    public boolean excluir(int id);
    public List consultar();
    public EntidadeDominio consultar(EntidadeDominio entidade);
    
}
