package TaskitTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Teste Automatizados da Funcionalidade SignUp") //Nome a ser mostrado quando executar o teste
public class SignUpTests {
    @Test
    @DisplayName("Registrar um novo usuario com dados validos")

    public void testRegistrarUmNovoUsuarioComDadosValidos(){

    //Vou abrir o chrome
    WebDriverManager.chromedriver().setup();
    WebDriver navegador = new ChromeDriver();
    navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    navegador.manage().window().maximize(); //Maximizar browser

    //Abrir o site do Taskit
    navegador.get("http://www.juliodelima.com.br/taskit/");

    //Vou clicar o botão que tem o id do "SignUp"
    navegador.findElement(By.id("signup")).click();

    //vou digitar o nome no campo com ID igual a name-sign-up
        navegador.findElement(By.id("name-sign-up")).sendKeys("Leandro Ucuamba");

    //vou digitar o login no campo com ID igual a login-sign-up
            navegador.findElement(By.id("login-sign-up")).sendKeys("LeandroSantos22");

        //vou digitar a senha no campo com ID igual a password-sign-up
        navegador.findElement(By.id("password-sign-up")).sendKeys("123456789");

        //Vou clicar o botão com ID igual "btn-submit-sign-up"
        navegador.findElement(By.id("btn-submit-sign-up")).click();

        //Validar que o texto "Hi, nome_usuario" foi apresentado depois de ser registrado
        String saudacaoAtual = navegador.findElement(By.className("me")).getText();
        Assertions.assertEquals("Hi, Leandro Ucuamba", saudacaoAtual);

        //clicar no menu "logout"
        navegador.findElement(By.xpath("/html/body/nav/div/div/ul[1]/li[3]/a")).click();

        //clicar no botão "signin"
        navegador.findElement(By.className("modal-trigger")).click();

        //preencher o usuario no signin
        navegador.findElement(By.id("login-sign-in")).sendKeys("LeandroSantos22");

        //preencher o senha no signin
        navegador.findElement(By.id("password-sign-in")).sendKeys("123456789");

        //clicar no botão "signin"
        navegador.findElement(By.id("btn-submit-sign-in")).click();


    }
}
