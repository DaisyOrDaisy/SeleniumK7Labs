package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavascriptAlert implements Urls {
    private static final By jsAlertSelector= By.cssSelector("[onclick=\"jsAlert()\"]");
    private static final By jsAlertConfirmSelector= By.cssSelector("[onclick=\"jsConfirm()\"]");
    private static final By jsAlertPromptSelector= By.cssSelector("[onclick=\"jsPrompt()\"]");
    private static final By resultSelector= By.cssSelector("#result");
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.getChromeDriver();
        try {
            driver.get(baseUrl.concat(jsAlertUrl));
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5L));

            // locate elements
            Alert alert;
            WebElement triggerJsAlert;
            WebElement result=driver.findElement(resultSelector);
            //System.out.println(result.getText());


            // interact
            // jsAlert
            triggerJsAlert=driver.findElement(jsAlertSelector);
            triggerJsAlert.click();
            alert=wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("1st alert: "+alert.getText());
            alert.accept();


            // jsConfirm
            triggerJsAlert=driver.findElement(jsAlertConfirmSelector);
            triggerJsAlert.click();
            alert=wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("2nd alert: "+alert.getText());
            alert.dismiss();


            //jsPrompt
            triggerJsAlert=driver.findElement(jsAlertPromptSelector);
            triggerJsAlert.click();
            alert=wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("3rd alert: "+alert.getText());
            alert.sendKeys("hello alert!!!!");
            alert.accept();
            System.out.println(result.getText());


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }

}
