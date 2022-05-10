package models.components;

import org.openqa.selenium.WebDriver;

public class InternalLoginPage extends MyLoginPage{
    public InternalLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void inputUserName(String username) {
        System.out.println("internal____input username____________________________|");
    }

    @Override
    public void inputPassword(String password) {
        System.out.println("internal____input password____________________________|");

    }

    @Override
    public void clickLoginButton() {
        System.out.println("internal____click login button____________________________|");

    }
}
