package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver navegador; //Tenha um atributo da classe que seja Webdrive

    public LoginPage(WebDriver navegador){
        this.navegador = navegador; //Pegue um navegador externo e jogue para fora
    }

    public LoginPage informarOUsuario(String usuario){
        navegador.findElement(By.cssSelector("label[for='usuario']")).click(); //Digitando no campo usuário
        navegador.findElement(By.id("usuario")).sendKeys(usuario); //SendKeys sig digite
        return this;
    }

    public LoginPage informarASenha(String senha){
        navegador.findElement(By.cssSelector("label[for='senha']")).click(); //Digitando no campo senha
        navegador.findElement(By.id("senha")).sendKeys(senha);
        return this;
    }

    public ListaDeProdutosPage submeterFormularioDeLogin(){
        navegador.findElement(By.cssSelector("button[type='submit']")).click();
        return new ListaDeProdutosPage(navegador);
    }
}
