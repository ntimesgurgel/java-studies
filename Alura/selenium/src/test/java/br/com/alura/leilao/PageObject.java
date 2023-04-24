package br.com.alura.leilao;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {
    protected ChromeDriver browser;
    protected static final String URL_LOGIN = "http://localhost:8080/login";
    public PageObject(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_LOGIN);
    }
    public void login(String username, String password) {
        this.browser.findElement(By.id("username")).sendKeys(username);
        this.browser.findElement(By.id("password")).sendKeys(password);
        this.browser.findElement(By.id("login-form")).submit();
    }
    public void goTo(String url) {
        this.browser.navigate().to(url);
    }
    public String getCurrentUrl() {
        return this.browser.getCurrentUrl().toString();
    }
    public void close(){
        this.browser.quit();
    }
}
