package test.pom;

import api_learning.Urls;
import driver.DriverFactory;
import models.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginTest_POM_03 implements Urls {
    public static void main(String[] args) {
        WebDriver driver=DriverFactory.getChromeDriver();
        try {
            driver.get(baseUrl.concat(loginUrl));
            LoginPage loginPage=new LoginPage(driver);
            loginPage.inputUserName_("_Hello LoginTest_POM_02.....").inputPassword_("secret password")
                    .clickLoginButton();
            Thread.sleep(3000);// debug purpose
            
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();

        }
    }
}
