package br.com.fatecmc.joaodebarro.pageobject;

import org.openqa.selenium.WebDriver;

public abstract class PageObject {
    private WebDriver driver;
    
    public PageObject(WebDriver driver){
        this.driver = driver;
    }
    
    public void acessar(String link) {
        driver.get(link);
    }
    
}
