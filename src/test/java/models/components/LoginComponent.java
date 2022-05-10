package models.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@ComponentCssSelector(value = "#login")
public class LoginComponent extends Component{
    private final By usernameSelector= By.id("username");
    private final By passwordSelector= By.id("password");
    public LoginComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
    public LoginComponent inputUsername(String username){
        WebElement usernameInput=this.findWebElement(usernameSelector);
        usernameInput.clear();
        usernameInput.sendKeys(username);
        return this;
    }
    public LoginComponent inputPassword(String password){
        WebElement passwordInput=this.findWebElement(passwordSelector);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }
    public void clickLoginButton(){
        this.findWebElement(By.cssSelector("[type=submit]")).click();
    }
}
