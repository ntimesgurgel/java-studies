package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesPage extends PageObject {
    public static final String URL_LEILOES = "http://localhost:8080/leiloes";
    public LeiloesPage(String username, String password){
        super();
        this.login(username, password);
    }
    public void registerAuction(String name, String value, String today) {
        this.browser.findElement(By.id("nome")).sendKeys(name);
        this.browser.findElement(By.id("valorInicial")).sendKeys(value);
        this.browser.findElement(By.id("dataAbertura")).sendKeys(today);
        this.browser.findElement(By.id("button-submit")).submit();
    }
    public boolean isAuctionRegistered(String name, String value, String today) {
        WebElement lastLine = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));

        String lastName = lastLine.findElement(By.cssSelector("td:nth-child(1)")).getText();
        String lastDate = lastLine.findElement(By.cssSelector("td:nth-child(2)")).getText();
        String lastValue = lastLine.findElement(By.cssSelector("td:nth-child(3)")).getText();

        return name.equals(lastName) && value.equals(lastValue) && today.equals(lastDate);
    }
    public boolean isPage(String url) {
        return this.browser.getCurrentUrl().toString().equals(url);
    }
    public boolean hasErrorMessages() {
        String pageSource = this.browser.getPageSource();
        return pageSource.contains("minimo 3 caracteres") &&
                pageSource.contains("não deve estar em branco") &&
                pageSource.contains("deve ser um valor maior de 0.1") &&
                pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
    }
}
