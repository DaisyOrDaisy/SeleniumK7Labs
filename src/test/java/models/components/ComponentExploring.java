package models.components;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;

public class ComponentExploring {
    public<T extends MyLoginPage> void login(Class<T> loginPageClass){
        Class<?>[] parameter=new Class[]{WebDriver.class};

        try {
            Constructor<T> constructor=loginPageClass.getConstructor(parameter);
            T loginPageObject=constructor.newInstance(DriverFactory.getChromeDriver());
            loginPageObject.inputUserName("component_login_age_object");
            loginPageObject.inputPassword("my_pass");
            loginPageObject.clickLoginButton();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ComponentExploring().login(InternalLoginPage.class);
        System.out.println("-------------------------------------------------@*@-----------------------------------------");
        new ComponentExploring().login(ExternalLoginPage.class);
    }
}
