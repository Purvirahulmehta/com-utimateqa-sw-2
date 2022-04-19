package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BeseTest {
    public static WebDriver driver;
    public void openBrowser(String baseUrl){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        //Launch the url
        driver.get(baseUrl);
        //maximize the window
        driver.manage().window().maximize();
        //implict time to the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    public void closeBrowser(){
        driver.quit();
    }
}

