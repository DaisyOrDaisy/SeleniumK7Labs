package test.pom;

import api_learning.Urls;
import driver.DriverFactory;
import models.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest_POM_02 implements Urls {
    public static void main(String[] args) {
        WebDriver driver=DriverFactory.getChromeDriver();
        try {
            driver.get(baseUrl.concat(loginUrl));
            LoginPage loginPage=new LoginPage(driver);
            loginPage.inputUserName("_Hello LoginTest_POM_02.....");
            Thread.sleep(2000);// debug purpose
            loginPage.inputPassword("secret password");
            Thread.sleep(2000);//debug purpose
            loginPage.clickLoginButton();
            Thread.sleep(3000);// debug purpose

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();

        }
    }
}
