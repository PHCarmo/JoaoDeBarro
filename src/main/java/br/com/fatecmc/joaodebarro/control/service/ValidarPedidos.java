package br.com.fatecmc.joaodebarro.control.service;

import br.com.fatecmc.joaodebarro.model.dao.RotinasDAO;
import java.util.Date;
import java.util.TimerTask;

public class ValidarPedidos extends TimerTask {

    @Override
    public void run() {
        System.out.println("Validando pedidos: " + new Date());
        new RotinasDAO().processarPedidos();
    }
    
}
