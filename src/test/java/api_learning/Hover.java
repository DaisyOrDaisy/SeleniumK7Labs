package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Hover implements Urls{
    private static final By figureSelector= By.className("figure");
    private static final By userNameSelector= By.cssSelector("h5");
    private static final By profileLinkSelector= By.cssSelector("a");
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.getChromeDriver();
        try {
            driver.get(baseUrl.concat(hoversUrl));
            //locate list figure
            List<WebElement> figures=driver.findElements(figureSelector);
            if(figures.isEmpty()){
                throw new RuntimeException("there is no figure!");
            }

           // define an Action
            Actions actions=new Actions(driver);
            for (WebElement figure : figures) {
                WebElement username=figure.findElement(userNameSelector);
                WebElement profileLink=figure.findElement(profileLinkSelector);
                // check the visible of the figure when the figure isn't hovered
                System.out.println("when i haven't hover figure: + username displayed: "+username.isDisplayed());
                System.out.println("when i haven't hover figure: + profile link displayed: "+profileLink.isDisplayed());
                // after mouse hover
                actions.moveToElement(figure).perform();
                System.out.println("when i hover figure: + username displayed: "+username.isDisplayed());
                System.out.println("when i hover figure: + profile link displayed: "+profileLink.isDisplayed());
                // print info
                System.out.println("_________________"+username.getText()+"~"+profileLink.getAttribute("href")+" _________________");

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}
