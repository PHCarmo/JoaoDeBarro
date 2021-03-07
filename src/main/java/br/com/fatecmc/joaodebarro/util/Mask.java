package br.com.fatecmc.joaodebarro.util;

public class Mask {
    
    public static String toCPF(String cpf){
        while(cpf.length() < 11) { cpf += "*"; }
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }
    
}
