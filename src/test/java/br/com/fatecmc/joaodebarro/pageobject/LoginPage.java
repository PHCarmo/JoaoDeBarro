package br.com.fatecmc.joaodebarro.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageObject {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void acessarLogin() {
        aguardarCarregar();
        driver.findElement(By.id("user")).click();
        aguardarCarregar();
    }

    public void preencherRegistro(String email, String senha) throws InterruptedException {
        driver.findElement(By.name("usu_si_email")).sendKeys(email);
        driver.findElement(By.name("usu_si_senha")).sendKeys(senha);
        driver.findElement(By.name("usu_si_conf_senha")).sendKeys(senha);
        rolarPagina(5);
        driver.findElement(By.id("registrar")).click();
    }

}
