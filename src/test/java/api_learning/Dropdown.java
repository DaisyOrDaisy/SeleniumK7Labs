package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown implements Urls{
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.getChromeDriver();
       try {
           driver.get(baseUrl.concat(dropdownUrl));
           // dropdown locator & element
           By dropdownSelector=By.id("dropdown");
           WebElement dropdown= driver.findElement(dropdownSelector);
           // select dropdown
           Select dropdownSelect=new Select(dropdown);
           // select by visible text
           dropdownSelect.selectByVisibleText("Option 2");
           Thread.sleep(2000);

           //select by index
           dropdownSelect.selectByIndex(1);
           Thread.sleep(2000);

           // select by value
           dropdownSelect.selectByValue("2");
           Thread.sleep(2000);

       }catch (Exception e){
           e.printStackTrace();
       }finally {
           driver.quit();
       }
    }
}
