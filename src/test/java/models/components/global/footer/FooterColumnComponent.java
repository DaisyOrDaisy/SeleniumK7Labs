package models.components.global.footer;

import models.components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FooterColumnComponent extends Component {
    private static final By titleSelector=By.tagName("h3");
    private static final By linkSelector=By.tagName("a");
    //private static final By linkSelector=By.cssSelector("li a");

    public FooterColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
    public WebElement titleElement(){
        return component.findElement(titleSelector);
    }
    public List<WebElement> linkElements(){
        return component.findElements(linkSelector);
    }
}
