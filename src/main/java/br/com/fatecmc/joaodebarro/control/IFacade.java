package br.com.fatecmc.joaodebarro.control;

import br.com.fatecmc.joaodebarro.model.domain.EntidadeDominio;

public interface IFacade {
    
    public Object salvar(EntidadeDominio entidade);
    public String alterar(EntidadeDominio entidade);
    public String alterarStatus(EntidadeDominio entidade);
    public String excluir(EntidadeDominio entidade);
    public Object consultar(EntidadeDominio entidade);
    
}
