package br.com.fatecmc.joaodebarro.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdministradorPage extends PageObject {

    public AdministradorPage(WebDriver driver) {
        super(driver);
    }
    
    public void alterarStatusVenda(String botao) {
        aguardarCarregar();
        driver.findElement(By.cssSelector(String.format("a[title='%s']", botao))).click();
        driver.findElement(By.xpath("//*[text()='Absoluta!']")).click();
        aguardarCarregar();
    }
    
}
