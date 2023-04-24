package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;

public class LoginSteps {

    private Browser browser;
    private LoginPage loginPage;
    private LeiloesPage leiloesPage;
    @Dado("o usuário válido")
    public void o_usuario_valido(){
        this.browser = new Browser();
        this.browser.seed();
        this.loginPage = browser.getLoginPage();
    }

    @Dado("o usuário inválido")
    public void o_usuario_invalido(){
        this.browser = new Browser();
        this.browser.seed();
        this.loginPage = browser.getLoginPage();
    }

    @Quando("realiza login")
    public void realiza_login(){
        this.leiloesPage = this.loginPage.realizaLoginComo("fulano", "pass");
    }

    @Quando("tenta logar")
    public void tenta_logar(){
        this.leiloesPage = this.loginPage.realizaLoginComo("jorge", "1234");
    }

    @Entao("é redirecionado para a pagina de leilões")
    public void e_redirecionado_para_a_pagina_de_leiloes(){
        Assertions.assertTrue(
                this.leiloesPage.ehPaginaDeLeiloes()
        );
    }

    @Entao("continua na página de login")
    public void continua_na_pagina_de_login(){
        Assertions.assertFalse(
                this.leiloesPage.ehPaginaDeLeiloes()
        );
    }
}
