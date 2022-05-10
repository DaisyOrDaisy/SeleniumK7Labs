package models.pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;
    private static final By usernameSelector= By.id("username");
    private static final By passwordSelector= By.id("password");
    private static final By loginButtonSelector= By.cssSelector("[type=submit]");


    public LoginPage(WebDriver driver) {
        this.driver=driver;

    }

    public WebElement getUsernameElement(){
        return driver.findElement(usernameSelector);
    }
    public WebElement getPasswordElement(){
        return driver.findElement(passwordSelector);
    }
    public WebElement getLoginButtonElement(){
        return driver.findElement(loginButtonSelector);
    }
    public void inputUserName(String username){
        WebElement usernameElem=this.getUsernameElement();
        usernameElem.clear();
        usernameElem.sendKeys(username);
    }
    public void inputPassword(String password) {
        WebElement passwordElem = this.getPasswordElement();
        passwordElem.clear();
        passwordElem.sendKeys(password);
    }
    public LoginPage inputUserName_(String username){
        WebElement usernameElem=this.getUsernameElement();
        usernameElem.clear();
        usernameElem.sendKeys(username);
        return this;
    }
    public LoginPage inputPassword_(String password) {
        WebElement passwordElem = this.getPasswordElement();
        passwordElem.clear();
        passwordElem.sendKeys(password);
        return this;
    }
    public void clickLoginButton(){
        this.getLoginButtonElement().click();
    }
}
