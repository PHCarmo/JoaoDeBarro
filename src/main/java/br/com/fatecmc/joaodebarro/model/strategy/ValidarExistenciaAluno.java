package br.com.fatecmc.joaodebarro.model.strategy;

import br.com.fatecmc.joaodebarro.model.domain.EntidadeDominio;

public class ValidarExistenciaAluno implements IStrategy{

    @Override
    public String process(EntidadeDominio entidade) {
        boolean validarExistencia = false;
        
        if (validarExistencia)
            return "Aluno já cadastrado";
        
        return null;
    }
    
}
