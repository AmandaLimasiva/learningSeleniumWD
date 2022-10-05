package modulos.produtos;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes Web do Módulo de Produtos")
public class produtosTest {

        private WebDriver navegador;

        @BeforeEach
        public void beforeEach(){
                //Abrir o navagador
                System.setProperty("webdriver.chrome.driver", "C:\\drives\\ver106\\chromedriver.exe"); //é daqui oh :)
                this.navegador = new ChromeDriver();
                //Vou maximimar a tela
                this.navegador.manage().window().maximize();

                //Vou definir um tempo de espera padrão de 5 segundos - Espere antes de falhar o meu Teste);
                this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


                //Navegar para a página da lojinha Web
                this.navegador.get("http://165.227.93.41/lojinha-web/v2/");
        }

    @Test
    @DisplayName("Nao sera permitido registrar um produto com valor igual a zero")
    public void testNaoPermitidoRegistrarProdutoComValorIgualAZero(){


        //Fazer login
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()

        //Vou para a tela de registro de produto
                .acessarOFormularioDeNovoProduto()

        //Preencher dados do produto e o valor será igual a zero
                .informarNomeDoProduto("Coleção de Livros Harry Potter")
                .informarOPrecoDoProduto("000")
                .informarAsCoresDoProduto("Preto, Azul, Branco")

        //Submeter o formulário
                .SubmeterFormularioDeAdicaoComErro()

        //Validar a mensagem de erro exibida
                .capturarMensagemApresentada();
            Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada );
    }







        //Fechando o navegador
    @AfterEach
        public void afterEach(){
                navegador.quit();
    }

}
