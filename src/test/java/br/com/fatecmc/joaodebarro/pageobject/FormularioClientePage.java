package br.com.fatecmc.joaodebarro.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioClientePage extends PageObject {

    public FormularioClientePage(WebDriver driver) {
        super(driver);
    }

    public void preencherDadosPessoais(String cpf) {
        aguardarCarregar();
        driver.findElement(By.name("cli_nome")).sendKeys("Roberto Marcos da Silva");
        selecionarOpcao("cli_gen_id", "2");
        driver.findElement(By.name("cli_cpf")).sendKeys(cpf);
        preencherCampoData(By.name("cli_dt_nascimento"), "10/02/1987");
    }

    public void preencherTelefone() {
        selecionarOpcao("cli_tel_tte_id", "1");
        driver.findElement(By.name("cli_tel_ddd")).sendKeys("11");
        driver.findElement(By.name("cli_tel_numero")).sendKeys("987654321");
    }

    public void preencherEndereco(String cep) throws InterruptedException {
        driver.findElement(By.name("end_nome")).sendKeys("Minha Casa");
        driver.findElement(By.name("end_cep")).sendKeys(cep);
        driver.findElement(By.name("end_bairro")).sendKeys("Distrito Industrial");
        rolarPagina(13);
        selecionarOpcao("end_tlo_id", "5");
        driver.findElement(By.name("end_logradouro")).sendKeys("Santos Dumont");
        driver.findElement(By.name("end_numero")).sendKeys("190");
        selecionarOpcao("end_tre_id", "2");
        driver.findElement(By.name("end_cidade")).sendKeys("Andradina");
        driver.findElement(By.name("end_estado")).sendKeys("SP");
        driver.findElement(By.name("end_pais")).sendKeys("Brasil");
        selecionarOpcao("end_ten_id", "2");
        driver.findElement(By.name("end_observacao")).sendKeys("Bloco C");
        selecionarOpcao("end_proposito", "1");
        driver.findElement(By.name("operacao")).click();
    }

}
