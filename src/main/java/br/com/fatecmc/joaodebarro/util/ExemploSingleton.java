package br.com.fatecmc.joaodebarro.util;

public class ExemploSingleton {
    private static ExemploSingleton instance = null;
    
    private ExemploSingleton() { }
    
    public static ExemploSingleton getInstance(){
        if(instance == null) instance = new ExemploSingleton();
        return instance;
    }
    
}
