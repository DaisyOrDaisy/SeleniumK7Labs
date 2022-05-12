package test.global;

import driver.DriverFactory;
import models.components.global.TopMenuComponent;
import models.components.global.footer.FooterComponent;
import models.components.global.footer.InformationColumnComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;

public class FooterTest {

    @Test
    public void testFooterHomePage(){
        WebDriver driver= DriverFactory.getChromeDriver();
        try{
            driver.get("http://demowebshop.tricentis.com/");
            HomePage homePage=new HomePage(driver);
            TopMenuComponent topMenuComponent=homePage.topMenuComponent();
            List<WebElement> mainItemElements=topMenuComponent.mainItemElements();
            //todo throw err when mainItemElements is empty

            Thread.sleep(2000);

            WebElement randomMainItemElement=mainItemElements.get(new SecureRandom().nextInt(mainItemElements.size()));
            randomMainItemElement.click();
            //WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10L));
            //wait.until(ExpectedConditions.urlContains(randomMainItemElement.getText()));



            FooterComponent footerComponent=homePage.footerComponent();
            InformationColumnComponent informationColumnComponent=footerComponent.informationColumnComponent();
            System.out.println("==============================>"+informationColumnComponent.titleElement().getText());
            if(informationColumnComponent.linkElements().isEmpty()){
                throw new RuntimeException("[Error] there no link in footer column component");
            }
            informationColumnComponent.linkElements().forEach(link->{
                System.out.println("==========>"+link.getText()+": "+link.getAttribute("href"));
            });


            // similar
            System.out.println("==============================>"+footerComponent.myAccountColumnComponent().titleElement().getText());
            System.out.println("==============================>"+footerComponent.customerServiceColumnComponent().titleElement().getText());
            System.out.println("==============================>"+footerComponent.followUsColumnComponent().titleElement().getText());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();

        }


    }

    @Test
    public void testFooterCategoryPage(){
        System.out.println("Footer Test | Category page");

    }
}
