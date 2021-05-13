package br.com.fatecmc.joaodebarro.model.strategy;

import br.com.fatecmc.joaodebarro.model.domain.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaSenhaUsuario implements IStrategy {

    @Override
    public String process(EntidadeDominio entidade) {
        String pass = ((Usuario) entidade).getSenha();

        StringBuilder hex_pass = new StringBuilder();
        try {
            for (byte b : MessageDigest.getInstance("SHA-256").digest(pass.getBytes("UTF-8"))) {
                hex_pass.append(String.format("%02X", 0xFF & b));
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            System.out.println("Não foi possível criptograr a senha.\nErro: " + ex.getMessage());
            return null;
        }

        ((Usuario) entidade).setSenha(hex_pass.toString());

        return null;
    }

}
