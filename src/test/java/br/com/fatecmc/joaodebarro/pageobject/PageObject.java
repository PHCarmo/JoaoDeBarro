package br.com.fatecmc.joaodebarro.pageobject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObject {
    protected WebDriver driver;
    
    public PageObject(WebDriver driver){
        this.driver = driver;
    }
    
    public void acessar(String link) {
        driver.get(link);
    }
    
    public void aguardarCarregar() {
        new WebDriverWait(driver, 30).until(
            ExpectedConditions.invisibilityOfElementLocated(By.className("loader"))
        );
    }
    
    public void rolarPagina(int vezes) throws InterruptedException {
        for(int i=0; i<vezes; i++){
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        }
    }
    
    public void selecionarOpcao(String name, String value) {
        WebElement option_input = driver.findElement(By.cssSelector(
                String.format("[name='%s']+div.nice-select", name)));
        option_input.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        option_input.findElement(By.cssSelector(String.format("li[data-value='%s']", value))).click();
    }
    
    public void preencherCampoData(By by, String date) {
        WebElement date_input = driver.findElement(by);
        date_input.click();
        date_input.sendKeys(date.replace("/", ""));
    }
    
    public void filtrarTabela(String texto) {
        for(WebElement elemento: driver.findElements(By.cssSelector("input[type='search']"))){
            if(elemento.isDisplayed()){
                elemento.sendKeys(texto);
                break;
            }
        }
        for(WebElement loading: driver.findElements(By.xpath("//div[text()='Processando...']"))){
            new WebDriverWait(driver, 30).until(
                ExpectedConditions.invisibilityOf(loading)
            );
        }
    }
    
}
