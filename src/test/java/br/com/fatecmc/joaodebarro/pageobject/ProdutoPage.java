package br.com.fatecmc.joaodebarro.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProdutoPage extends PageObject {

    public ProdutoPage(WebDriver driver) {
        super(driver);
    }
    
    public void acessarProduto(String id) {
        aguardarCarregar();
        driver.findElement(By.id(id)).click();
    }
    
    public void adicionarProdutoCarrinho(String qtd) throws InterruptedException {
        aguardarCarregar();
        driver.findElement(By.name("pcr_qtd")).clear();
        driver.findElement(By.name("pcr_qtd")).sendKeys(qtd);
        rolarPagina(4);
        driver.findElement(By.name("operacao")).click();
    }
}
