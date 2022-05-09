package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginForm {
    public static void main(String[] args) {
        WebDriver driver=DriverFactory.getChromeDriver();

        try {
            //Navigate to target page
            driver.get("https://the-internet.herokuapp.com/login");
            // Define locators
            By usrNameSelector = By.id("username");
            By pswSelector = By.cssSelector("#password");
            By loginBtnSelector = By.cssSelector("[type=submit]");

            // find elements
            WebElement usrNameInput= driver.findElement(usrNameSelector);
            WebElement pswInput= driver.findElement(pswSelector);
            WebElement loginBtn= driver.findElement(loginBtnSelector);

            // Interact with elements
            usrNameInput.clear();
            usrNameInput.sendKeys("tomsmith");
            pswInput.clear();
            pswInput.sendKeys("SuperSecretPassword!");
            loginBtn.click();

            // on the next page
            printPageInfo(driver);

            // find h4 tag
            By welcomeTagSel=By.cssSelector("h4");
            WebElement welcomeTagElement=driver.findElement(welcomeTagSel);
            System.out.println("#-------------wwwwwwwwwwwwwwwwwwwwwwwww------------------->"+welcomeTagElement.getText());
            // debug purpose only
            Thread.sleep(2000);

            // go back to the login page
            driver.navigate().back();
            printPageInfo(driver);

            // multiple elements
            List<WebElement> allInputElements=driver.findElements(By.tagName("input"));
            final int USERNAME_INDEX=0;
            final int PASSWORD_INDEX=1;
            if(!allInputElements.isEmpty()){
                usrNameInput=allInputElements.get(USERNAME_INDEX);
                pswInput=allInputElements.get(PASSWORD_INDEX);

                usrNameInput.clear();
                usrNameInput.sendKeys("new username");

                pswInput.clear();
                pswInput.sendKeys("new password");

            }else
                System.out.println("[ERR] --------------> the login form doesn't exist!");

            // debug purpose only
            Thread.sleep(3000);

            // get flash error message
            driver.findElement(loginBtnSelector).click();
            WebElement flashErrorMessage=driver.findElement(By.cssSelector(".error"));
            String backgroundColorErrorMessage=flashErrorMessage.getCssValue("background-color");
            System.out.println("#------wwwwwwwwwwww--------------->"+backgroundColorErrorMessage);
            System.out.println("#------wwwwwwwwwwww--------------->"+flashErrorMessage.getText());
            Thread.sleep(3000);// debug purpose only

            // find the footer powered by link text
            By poweredByLinkSelector=By.linkText("Elemental Selenium");
            WebElement poweredByLink=driver.findElement(poweredByLinkSelector);
            System.out.printf("#------wwwwwwwwwwww--------------->the text of powered By Link: "+poweredByLink.getText());
            Thread.sleep(3000);// debug purpose only
            poweredByLink.click();
            Thread.sleep(5000);// debug purpose only


        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //close driver session
            driver.quit();
        }
    }
    public static void printPageInfo(WebDriver driver){
        System.out.println("#-------------wwwwwwwwwwwwwwwwwwwwwwwww------------------->"+driver.getTitle());
        System.out.println("#-------------wwwwwwwwwwwwwwwwwwwwwwwww------------------->"+driver.getCurrentUrl());

    }



}

