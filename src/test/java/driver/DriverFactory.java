package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class DriverFactory {
    public static WebDriver getChromeDriver(){
        String currentProjectLocation=System.getProperty("user.dir");
        String macOSChromePath="/src/test/resources/drivers/chromedriver";
        String winChromePath="/src/test/resources/drivers/chromedriver.exe";
        String relativeChromeDriverPath= OS.isFamilyMac() ? macOSChromePath : winChromePath;
        String chromeDriverPath=currentProjectLocation.concat(relativeChromeDriverPath);
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);

        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        WebDriver driver= new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000L));
        return driver;


    }
}
