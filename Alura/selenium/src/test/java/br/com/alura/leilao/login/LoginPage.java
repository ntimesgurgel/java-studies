package br.com.alura.leilao.login;

import br.com.alura.leilao.PageObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends PageObject {
    public LoginPage() {
        super();
    }

    public String getText(String id){
        try{
            return this.browser.findElement(By.id(id)).getText();
        } catch(NoSuchElementException e){
            return null;
        }
    }

    public Boolean contains(String text) {
        return this.browser.getPageSource().contains(text);
    }
}
