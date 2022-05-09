package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControl {
    public static void main(String[] args) {
        WebDriver driver=DriverFactory.getChromeDriver();

        try {
            //Navigate to target page
            driver.get("https://the-internet.herokuapp.com/dynamic_controls");
            // Define locators
            By checkboxFormSelector=By.id("checkbox-example");
            By checkboxButtonSelector=By.cssSelector("input");
            By inputFormSelector=By.id("input-example");
            By inputTagSelector=By.cssSelector("input");



            // find elements
            WebElement checkboxForm=driver.findElement(checkboxFormSelector);
            WebElement checkboxButton=checkboxForm.findElement(checkboxButtonSelector);
            WebElement inputForm=driver.findElement(inputFormSelector);
            WebElement inputTag=inputForm.findElement(inputTagSelector);
            WebElement enableButton=inputForm.findElement(By.cssSelector("button"));

            Thread.sleep(2000);// debug purpose only

            // Interact with elements
            checkboxButton.click();
            if(!inputTag.isEnabled()){
                enableButton.click();
            }
            WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(15L));
            webDriverWait.until(ExpectedConditions.elementToBeClickable(inputTag));
            //webDriverWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
            inputTag.sendKeys("hello, this is Stella");
            Thread.sleep(2000);// debug purpose only



            // on the next page


        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //close driver session
            driver.quit();
        }
    }

}

