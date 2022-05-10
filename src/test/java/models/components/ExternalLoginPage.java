package models.components;

import org.openqa.selenium.WebDriver;

public class ExternalLoginPage extends MyLoginPage{
    public ExternalLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void inputUserName(String username) {
        System.out.println("external____input username____________________________|");
    }

    @Override
    public void inputPassword(String password) {
        System.out.println("external____input password____________________________|");

    }

    @Override
    public void clickLoginButton() {
        System.out.println("external____click login button____________________________|");

    }
}
