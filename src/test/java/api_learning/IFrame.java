package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFrame implements Urls{
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.getChromeDriver();
        try {
            driver.get(baseUrl.concat(iframeUrl));

            // locate iframe
            By iFrameSelector= By.cssSelector("#mce_0_ifr");
            WebElement iFrame=driver.findElement(iFrameSelector);

            // switch to iframe
            driver.switchTo().frame(iFrame);

            // interact with iframe
            WebElement tinyMCE=driver.findElement(By.cssSelector("#tinymce"));
            tinyMCE.clear();
            tinyMCE.sendKeys("How come...the course is going to end :((");
            Thread.sleep(3000);// debug purpose only

            // switch to default frame
            driver.switchTo().defaultContent();
            System.out.println("#------------WWWWWWWWWWWWWWW-------->"+driver.findElement(By.linkText("Elemental Selenium")).getAttribute("href"));

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}
