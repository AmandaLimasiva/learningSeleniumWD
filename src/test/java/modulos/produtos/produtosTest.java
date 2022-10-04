package modulos.produtos;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Testes Web do Módulo de Produtos")
public class produtosTest {
    @Test
    @DisplayName("Nao sera permitido registrar um produto com valor igual a zero")
    public void testNaoPermitidoRegistrarProdutoComValorIgualAZero(){
        //Abrir o navagador
            System.setProperty("webdriver.chrome.driver", "C:\\drives\\ver106\\chromedriver.exe"); //é daqui oh :)
            WebDriver navegador = new ChromeDriver();
            //Vou maximimar a tela
            navegador.manage().window().maximize();

            //Vou definir um tempo de espera padrão de 5 segundos - Espere antes de falhar o meu Teste);
            navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        //Navegar para a página da lojinha Web
            navegador.get("http://165.227.93.41/lojinha-web/v2/");

        //Fazer login
            navegador.findElement(By.cssSelector("label[for='usuario']")).click(); //Digitando no campo usuário
            navegador.findElement(By.id("usuario")).sendKeys("admin"); //SendKeys sig digite

            navegador.findElement(By.cssSelector("label[for='senha']")).click(); //Digitando no campo senha
            navegador.findElement(By.id("senha")).sendKeys("admin");

            navegador.findElement(By.cssSelector("button[type='submit']")).click();

        //Vou para a tela de registro de produto
            navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        //Preencher dados do produto e o valor será igual a zero
            navegador.findElement(By.id("produtonome")).sendKeys("Livro Harry Potter");
            navegador.findElement(By.name("produtovalor")).sendKeys("000");
            navegador.findElement(By.id("produtocores")).sendKeys("Preto, Branco");

        //Submeter o formulário
            navegador.findElement(By.cssSelector("button[type='submit']")).click();


        //Validar a mensagem de erro exibida
            String mensagemToats = navegador.findElement(By.cssSelector(".toast.rounded")).getText();
            Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemToats );

            //Fechando o navegador
            navegador.quit();
    }
}
