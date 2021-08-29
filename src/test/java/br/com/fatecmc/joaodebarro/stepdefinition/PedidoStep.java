package br.com.fatecmc.joaodebarro.stepdefinition;

import br.com.fatecmc.joaodebarro.util.WebDriverSingleton;
import br.com.fatecmc.joaodebarro.pageobject.*;
import io.cucumber.java.pt.*;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PedidoStep {

    protected WebDriver driver;

    public PedidoStep() {
        this.driver = WebDriverSingleton.getInstance().getDriver();
    }

    @Dado("a página de produtos é acessada")
    public void a_página_de_produtos_é_acessada() {
        new LoginPage(driver).acessar("http://localhost:8080/JoaoDeBarro/faces/loja.jsp");
    }
    
    @Quando("o produto {string} é visualizado em detalhes")
    public void um_produto_é_visualizado_em_detalhes(String produto) {
        new ProdutoPage(driver).acessarProduto(produto);
    }
    
    @Quando("{string} produto é adicionado ao carrinho")
    public void o_produto_é_adicionado_ao_carrinho(String quantidade) throws InterruptedException {
        new ProdutoPage(driver).adicionarProdutoCarrinho(quantidade);
    }
    
    @Quando("a página de carrinho é acessada")
    public void a_página_de_carrinho_é_acessada() {
        new LoginPage(driver).acessar("http://localhost:8080/JoaoDeBarro/faces/carrinho?operacao=CONSULTAR");
    }
    
    @Quando("o checkout é feito com os dados disponíveis")
    public void o_checkout_é_feito_com_os_dados_disponíveis() throws InterruptedException {
        new CarrinhoPage(driver).realizarCheckout();
    }
    
    @Quando("o checkout é feito usando os cartões e cupons")
    public void o_checkout_é_feito_usando_os_cartões_e_cupons() throws InterruptedException {
        new CarrinhoPage(driver).realizarCheckoutDoisCartoes();
    }
    
    @Quando("um novo cartão é iniciado cadastro")
    public void um_novo_cartão_é_iniciado_cadastro() throws InterruptedException {
        new CarrinhoPage(driver).iniciarCadastroCartao();
    }
        
    @Dado("a página de administrador é acessada")
    public void a_página_de_administrador_é_acessado() {
        new LoginPage(driver).acessar("http://localhost:8080/JoaoDeBarro/faces/admin.jsp");
    }
        
    @Dado("o cliente possui um pedido já aprovado")
    public void o_cliente_possui_um_pedido_já_aprovado() {
        for(int i=0; i<15; i++){
            new LoginPage(driver).acessar("http://localhost:8080/JoaoDeBarro/faces/cliente?operacao=CONSULTAR");
            new ClientePage(driver).acessarMenu("Compras");
            new AdministradorPage(driver).filtrarTabela("Aprovada");
            if(driver.findElements(By.xpath("//div[contains(text(),'Aprovada')]")).size() > 0) break;
        }
    }
    
    @Dado("existe um pedido {string}")
    public void existe_um_pedido(String status) {
        new AdministradorPage(driver).filtrarTabela(status);
        Assert.assertTrue(driver.findElements(By.xpath("//div[contains(text(),'"+status+"')]")).size() > 0);
    }
    
    @Quando("o transporte é definido para a etapa {string}")
    public void o_transporte_é_definido_para_a_etapa(String etapa) {
        new AdministradorPage(driver).alterarStatusVenda(etapa);
    }
        
    @Quando("é realizada a ação {string}")
    public void é_realizada_a_ação(String acao) {
        driver.findElement(By.cssSelector(String.format("a[title='%s']", acao))).click();
    }
    
    @Quando("todos itens de troca são selecionados")
    public void todos_itens_de_troca_são_selecionados() throws InterruptedException {
        new TrocaPage(driver).selecionarTodosItens();
    }
    
    @Quando("a troca é confirmada")
    public void a_troca_é_confirmada() throws InterruptedException {
        new TrocaPage(driver).confirmarTroca();
    }
    
    @Então("é gerado um vale-troca para o cliente")
    public void é_gerado_um_vale_troca_para_o_cliente() {
        new LoginPage(driver).acessar("http://localhost:8080/JoaoDeBarro/faces/cliente?operacao=CONSULTAR");
        new ClientePage(driver).acessarMenu("Vale-Troca");
        Assert.assertTrue(driver.findElements(By.cssSelector("#tab_vale .card")).size() > 0);
    }
    
    @Então("a página de perfil de administrador é exibida")
    public void a_página_de_perfil_de_administrador_é_exibida() {
        Assert.assertTrue(driver.findElements(By.xpath("//h2[contains(text(),'Administração')]")).size() > 0);
    }
    
    @Então("é exibida a modal com o erro {string}")
    public void é_exibida_a_modal_com_o_erro(String erro) {
        Assert.assertTrue(driver.findElements(By.xpath("//*[@id='modal-error-alert']//*[contains(text(), '"+erro+"')]")).size() > 0);
    }
    
}
