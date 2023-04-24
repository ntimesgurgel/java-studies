package br.com.alura.leilao.login;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginTest {
    private LoginPage loginPage;
    @BeforeEach
    public void beforeEach(){
        this.loginPage = new LoginPage();
    }
    @Test
    public void loginWithValidData(){
        loginPage.login("fulano", "pass");

        String URL_INDEX = "http://localhost:8080/leiloes";

        Assertions.assertTrue(
                loginPage.getCurrentUrl().equals(URL_INDEX)
        );

        Assertions.assertEquals(
                "fulano",
                loginPage.getText("usuario-logado")
        );
    }
    @Test
    public void dontLoginWithInvalidData(){
        loginPage.login("invalido", "pass");

        String URL_LOGIN_ERROR = "http://localhost:8080/login?error";
        Assertions.assertTrue(
                loginPage.getCurrentUrl().equals(URL_LOGIN_ERROR)
        );

        Assertions.assertTrue(
                loginPage.contains("Usuário e senha inválidos.")
        );

        Assertions.assertNull(
                loginPage.getText("usuario-logado")
        );
    }

    @Test
    public void dontAccessWithoutLogin(){
        loginPage.goTo("http://localhost:8080/leiloes/2");

        Assertions.assertFalse(
                loginPage.getCurrentUrl().equals("http://localhost:8080/leiloes/2")
        );
        Assertions.assertFalse(
                loginPage.contains("Dados do Leilão")
        );
    }

    @AfterEach
    public void afterEach(){
        loginPage.close();
    }
}
