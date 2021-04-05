package br.com.fatecmc.joaodebarro.stepdefinition;

import br.com.fatecmc.joaodebarro.pageobject.*;
import br.com.fatecmc.joaodebarro.util.WebDriverFactory;
import io.cucumber.java.pt.*;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClienteStep {

    protected WebDriver driver;

    public ClienteStep() {
        driver = WebDriverFactory.startBrowser("Chrome");
    }

    @Dado("a página inicial é acessada")
    public void a_página_inicial_é_acessada() {
        new LoginPage(driver).acessar("http://localhost:8080/JoaoDeBarro/faces/index.jsp");
    }

    @Dado("a página de login é acessada")
    public void a_página_de_login_é_acessada() {
        new LoginPage(driver).acessarLogin();
    }

    @Dado("a página de perfil é acessada")
    public void a_página_de_perfil_é_acessada() {
        new LoginPage(driver).acessar("http://localhost:8080/JoaoDeBarro/faces/cliente.jsp");
    }

    @Quando("{string} é visualizado")
    public void é_visualizado(String titulo) {
        new ClientePage(driver).acessarMenu(titulo);
    }

    @Quando("o cadastro de {string} é inicializado")
    public void o_cadastro_de_é_inicializado(String item) {
        new ClientePage(driver).iniciarCadastro(item);
    }

    @Quando("os dados de registro {string} {string} são preenchidos")
    public void os_dados_de_registro_são_preenchidos(String email, String senha) throws InterruptedException {
        new LoginPage(driver).preencherRegistro(email, senha);
    }

    @Quando("os dados do cliente {string} são preenchidos")
    public void os_dados_do_cliente_são_preenchidos(String cpf) {
        new FormularioClientePage(driver).preencherDadosPessoais(cpf);
        new FormularioClientePage(driver).preencherTelefone();
    }

    @Quando("os dados de endereço {string} são preenchidos")
    public void os_dados_de_endereço_são_preenchidos(String cep) throws InterruptedException {
        new FormularioClientePage(driver).preencherEndereco(cep);
    }

    @Quando("os dados de cartão {string} são preenchidos")
    public void os_dados_de_cartão_são_preenchidos(String numero) throws InterruptedException {
        new FormularioCartaoPage(driver).preencherDadosProprios(numero);
    }

    @Quando("a página de cadastro de cliente é exibida")
    public void a_página_de_cadastro_de_cliente_é_exibida() {
        Assert.assertTrue(driver.findElements(By.xpath("//h2[contains(text(),'Cliente')]")).size() > 0);
    }

    @Então("a página de perfil de cliente é exibida")
    public void a_página_de_perfil_de_cliente_é_exibida() {
        Assert.assertTrue(driver.findElements(By.xpath("//h2[contains(text(),'Perfil')]")).size() > 0);
    }
}
