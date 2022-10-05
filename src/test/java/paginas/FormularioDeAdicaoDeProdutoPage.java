package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeAdicaoDeProdutoPage {
    private WebDriver navegador;

    public FormularioDeAdicaoDeProdutoPage(WebDriver navegador){
        this.navegador = navegador;
   }

   public FormularioDeAdicaoDeProdutoPage informarNomeDoProduto(String produtoNome){
       navegador.findElement(By.id("produtonome")).sendKeys(produtoNome);
       return this;
   }

   public FormularioDeAdicaoDeProdutoPage informarOPrecoDoProduto(String produtoValor){
       navegador.findElement(By.name("produtovalor")).sendKeys(produtoValor);
       return this;
   }

   public FormularioDeAdicaoDeProdutoPage informarAsCoresDoProduto(String produtocores){
       navegador.findElement(By.id("produtocores")).sendKeys(produtocores);
       return this;
   }

   public ListaDeProdutosPage SubmeterFormularioDeAdicaoComErro(){
       navegador.findElement(By.cssSelector("button[type='submit']")).click();
       return new ListaDeProdutosPage(navegador);
   }

    public FormularioDeEdicaoDeProdutoPage SubmeterFormularioDeAdicaoComSucesso(){
        navegador.findElement(By.cssSelector("button[type='submit']")).click();
        return new FormularioDeEdicaoDeProdutoPage(navegador);
    }
}
