package br.com.fatecmc.joaodebarro.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioCartaoPage extends PageObject {

    public FormularioCartaoPage(WebDriver driver) {
        super(driver);
    }

    public void preencherDadosProprios(String numero) throws InterruptedException {
        aguardarCarregar();
        driver.findElement(By.name("crt_numero")).sendKeys(numero);
        driver.findElement(By.name("crt_nome")).sendKeys("Titular Teste");
        rolarPagina(9);
        selecionarOpcao("crt_mes_validade", "12");
        selecionarOpcao("crt_ano_validade", "2028");
        driver.findElement(By.name("crt_cvv")).sendKeys("380");
        selecionarOpcao("crt_bnd_id", "6");
        driver.findElement(By.name("operacao")).click();
    }
    
    public void preencherDadosPropriosInvalidos(String numero) throws InterruptedException {
        aguardarCarregar();
        driver.findElement(By.name("crt_numero")).sendKeys(numero);
        driver.findElement(By.name("crt_nome")).sendKeys("Titular Teste 2");
        rolarPagina(9);
        selecionarOpcao("crt_mes_validade", "1");
        selecionarOpcao("crt_ano_validade", "2021");
        driver.findElement(By.name("crt_cvv")).sendKeys("197");
        selecionarOpcao("crt_bnd_id", "1");
        driver.findElement(By.name("operacao")).click();
    }

}
