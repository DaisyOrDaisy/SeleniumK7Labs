package models.pages;

import models.components.LoginComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewLoginPage extends BasePage{

    public NewLoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginComponent getLoginComponent(){
        return getComponent(LoginComponent.class,driver);
    }

}
