package br.com.fatecmc.joaodebarro.pageobject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarrinhoPage extends PageObject {

    public CarrinhoPage(WebDriver driver) {
        super(driver);
    }
    
    public void selecionarEnderecos() throws InterruptedException {
        aguardarCarregar();
        rolarPagina(10);
        driver.findElement(By.cssSelector("body")).click();
        driver.findElement(By.name("entrega")).click();
        driver.findElement(By.name("cobranca")).click();
        rolarPagina(10);        
    }
    
    public void realizarCheckout() throws InterruptedException {
        selecionarEnderecos();
        selecionarOpcao("cpm_id", "4-20.0");
        
        driver.findElement(By.className("cartao")).sendKeys("320,00");
        rolarPagina(12);
        
        driver.findElement(By.cssSelector("[value='SALVAR']")).click();
    }
    
    public void realizarCheckoutDoisCartoes() throws InterruptedException {
        selecionarEnderecos();
        selecionarOpcao("cpm_id", "2-10.0");
        driver.findElement(By.className("valetroca")).click();
        
        for(WebElement valor_cartao: driver.findElements(By.className("cartao"))){
            valor_cartao.sendKeys("35,00");
        }
        rolarPagina(15);
        
        driver.findElement(By.cssSelector("[value='SALVAR']")).click();
    }
    
    public void iniciarCadastroCartao() throws InterruptedException {
        aguardarCarregar(); 
        rolarPagina(20);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.className("add-cartao-show")).click();
        driver.findElement(By.xpath("//div[@id='modal-add-cartao']//*[text()='Absoluta!']")).click();
    }
        
}
