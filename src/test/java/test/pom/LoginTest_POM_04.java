package test.pom;

import api_learning.Urls;
import driver.DriverFactory;
import models.pages.LoginPage;
import models.pages.NewLoginPage;
import org.openqa.selenium.WebDriver;

public class LoginTest_POM_04 implements Urls {
    public static void main(String[] args) {
        WebDriver driver=DriverFactory.getChromeDriver();
        try {
            driver.get(baseUrl.concat(loginUrl));
            NewLoginPage newLoginPage=new NewLoginPage(driver);
            newLoginPage.getLoginComponent().inputUsername("hello lession 18").inputPassword("secret password")
                            .clickLoginButton();
            Thread.sleep(3000);// debug purpose
            
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();

        }
    }
}
