package models.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.sql.Driver;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Component {
    protected WebDriver driver;
    protected WebElement component;
    protected WebDriverWait wait;

    public Component(WebDriver driver, WebElement component) {
        this.driver = driver;
        this.component = component;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15L));
    }
    public<T extends Component> List<T> getComponents(Class<T> myComponentClass, WebDriver driver ){
        Class<?>[] params=new Class[]{WebDriver.class,WebElement.class};
        Constructor<T> constructor;
        try {
            constructor=myComponentClass.getConstructor(params);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERR]* the component must have params: "+Arrays.toString(params));
        }
        String cssSelector;
        try{
            cssSelector=myComponentClass.getAnnotation(ComponentCssSelector.class).value();
        }catch (Exception e){
            throw new IllegalArgumentException("[ERR]* the component must have css Selector ! ");
        }
        List<WebElement> results=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(cssSelector)));
        List<T> components=results.stream().map(webElement->{
            try {
                return constructor.newInstance(driver,webElement);
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
        return components;
    }
    public<T extends Component> T getComponent(Class<T> myComponentClass, WebDriver driver ){
        return getComponents(myComponentClass,driver).get(0);


    }
    public WebElement findWebElement(By by){
        return component.findElement(by);
    }
    public List<WebElement> findWebElements(By by){
        return component.findElements(by);
    }

}
