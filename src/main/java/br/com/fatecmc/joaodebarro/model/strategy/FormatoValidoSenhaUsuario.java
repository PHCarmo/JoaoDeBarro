package br.com.fatecmc.joaodebarro.model.strategy;

import br.com.fatecmc.joaodebarro.model.domain.*;

public class FormatoValidoSenhaUsuario implements IStrategy{

    @Override
    public String process(EntidadeDominio entidade) {
        boolean validacao;
        
        Usuario p = (Usuario) entidade;
        validacao = p.getSenha().matches("^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[#?!@$%^&*-]).{8,}$");
        
        if(validacao)
            return "- Existem critérios para a senha não cumpridos.";
        
        return null;
    }
    
}
