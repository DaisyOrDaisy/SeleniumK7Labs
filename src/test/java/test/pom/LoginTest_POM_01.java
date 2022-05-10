package test.pom;

import api_learning.Urls;
import driver.DriverFactory;
import models.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest_POM_01 implements Urls {
    public static void main(String[] args) {
        WebDriver driver=DriverFactory.getChromeDriver();
        try {
            driver.get(baseUrl.concat(loginUrl));
            LoginPage loginPage=new LoginPage(driver);
            // navigate elements
            WebElement username=loginPage.getUsernameElement();
            WebElement password=loginPage.getPasswordElement();
            WebElement loginButton=loginPage.getLoginButtonElement();
            username.clear();
            username.sendKeys("hello laddies!");
            password.clear();
            password.sendKeys("thisIsmostSecretpass0rD");
            Thread.sleep(1000);
            loginButton.click();
            Thread.sleep(3000);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();

        }
    }
}
