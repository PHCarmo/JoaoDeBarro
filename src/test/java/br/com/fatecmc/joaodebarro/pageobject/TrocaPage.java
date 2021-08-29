package br.com.fatecmc.joaodebarro.pageobject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrocaPage extends PageObject {

    public TrocaPage(WebDriver driver) {
        super(driver);
    }
    
    public void selecionarTodosItens() throws InterruptedException {
        aguardarCarregar();
        rolarPagina(10);
        for(WebElement checkbox: driver.findElements(By.name("item"))){
            if(!checkbox.isSelected()) checkbox.click();
        }
    }
    
    public void confirmarTroca() throws InterruptedException {
        aguardarCarregar();
        rolarPagina(7);
        driver.findElement(By.name("operacao")).click();
    }
    
}
