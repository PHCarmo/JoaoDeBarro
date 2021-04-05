package br.com.fatecmc.joaodebarro.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClientePage extends PageObject {

    public ClientePage(WebDriver driver) {
        super(driver);
    }
    
    public void acessarMenu(String titulo) {
        aguardarCarregar();
        driver.findElement(By.xpath(String.format("//a[text()='%s']", titulo))).click();
    }
    
    public void iniciarCadastro(String item) {
        driver.findElement(By.id(String.format("novo_%s", item))).click();
        aguardarCarregar();
    }
}
