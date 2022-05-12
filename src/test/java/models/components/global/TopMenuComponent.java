package models.components.global;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@ComponentCssSelector(".top-menu")
public class TopMenuComponent extends Component {
    private static final By mainItemSel= By.cssSelector("li");
    public TopMenuComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
    public List<WebElement> mainItemElements(){
        return component.findElements(mainItemSel);
    }
}
