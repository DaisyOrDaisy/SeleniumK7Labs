package models.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class MyLoginPage {
    protected final WebDriver driver;

    public MyLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void inputUserName(String username);
    public abstract void inputPassword(String password);
    public abstract void clickLoginButton();
}
