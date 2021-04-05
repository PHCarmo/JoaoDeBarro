package br.com.fatecmc.joaodebarro.stepdefinition;

import br.com.fatecmc.joaodebarro.pageobject.ClientePage;
import br.com.fatecmc.joaodebarro.util.WebDriverFactory;
import io.cucumber.java.pt.*;

public class ClienteStep {
    ClientePage cliente;

    public ClienteStep() {
        cliente = new ClientePage(WebDriverFactory.startBrowser("Chrome"));
    }
        
    @Dado("a página inicial é acessada")
    public void a_página_inicial_é_acessada() {
        cliente.acessar("http://localhost:8080/JoaoDeBarro/faces/index.jsp");
    }

    @Dado("a página de login é acessada")
    public void a_página_de_login_é_acessada() {
        System.out.println("");
    }

    @Quando("os dados de registro {string} {string} são preenchidos")
    public void os_dados_de_registro_x_x_são_preenchidos(String email, String senha) {
        System.out.println("");
    }

    @Então("a página de cadastro de cliente é exibida")
    public void a_página_de_cadastro_de_cliente_é_exibida() {
        System.out.println("");
    }

}
