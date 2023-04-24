package br.com.alura.leilao.leiloes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeiloesTest {
    private String URL_NEW_LEILAO = "http://localhost:8080/leiloes/new";
    private LeiloesPage leiloesPage;
    @BeforeEach
    public void beforeEach(){
        leiloesPage = new LeiloesPage("fulano","pass");
    }

    @Test
    public void shouldSignUpAuction(){
        leiloesPage.goTo(URL_NEW_LEILAO);

        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String name = "Leilao do dia " + today;
        String value = "500.00";

        leiloesPage.registerAuction(name, value, today);
        String LEILOES_URL = "http://localhost:8080/leiloes";
        Assertions.assertTrue(
                leiloesPage.getCurrentUrl().equals(LEILOES_URL)
        );
        Assertions.assertTrue(
                leiloesPage.isAuctionRegistered(name, value, today)
        );
    }

    @Test
    public void validateAuctionRegister(){
        this.leiloesPage.goTo("http://localhost:8080/leiloes/new");
        this.leiloesPage.registerAuction("", "", "");

        Assertions.assertFalse(
                this.leiloesPage.isPage(URL_NEW_LEILAO)
        );

        Assertions.assertTrue(
                this.leiloesPage.hasErrorMessages()
        );
    }

    @AfterEach
    public void afterEach(){
        leiloesPage.close();
    }
}
