package br.com.fatecmc.joaodebarro.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClientePage extends PageObject {

    public ClientePage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(id="cli_nome") WebElement nome;
    
}
