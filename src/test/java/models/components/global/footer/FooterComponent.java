package models.components.global.footer;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@ComponentCssSelector(value = ".footer")
public class FooterComponent extends Component {
    public FooterComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
    public InformationColumnComponent informationColumnComponent(){
        return getComponent(InformationColumnComponent.class,driver);
    }
    public CustomerServiceColumnComponent customerServiceColumnComponent(){
        return getComponent(CustomerServiceColumnComponent.class,driver);
    }
    public MyAccountColumnComponent myAccountColumnComponent(){
        return getComponent(MyAccountColumnComponent.class,driver);
    }
    public FollowUsColumnComponent followUsColumnComponent(){
        return getComponent(FollowUsColumnComponent.class,driver);
    }

}
