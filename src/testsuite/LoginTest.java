package testsuite;

import browserfactory.BeseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BeseTest {
        String baseUrl = "https://courses.ultimateqa.com/";
        @Before
    public void setUp(){
            openBrowser(baseUrl);
        }
        @After
    public void teardown(){
            closeBrowser();
        }
        @Test
    public void userShouldNavigateToLoginPageSuccessfully (){
            //finding sing in button element
            WebElement signInLink=driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
            //sending click to sign in button
            signInLink.click();
            //finding wecome message element
            WebElement welcomeMessage=driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
            String result=welcomeMessage.getText();
            //expected message
            String expectedMessage="Welcome Back!";
            // //validate actual and expected message
            Assert.assertEquals("Welcome Message",result,expectedMessage);

        }
@Test
    public void verifyTheErrorMessage(){
            //finding sing in link element
    WebElement signInLink=driver.findElement(By.linkText("Sign In"));
    signInLink.click();
    //finding username element
    WebElement invalidUserName=driver.findElement(By.name("user[email]"));
    //sending username into username field
    invalidUserName.sendKeys("123456@gmail.com");
    //finding password
    WebElement invalidPassword=driver.findElement(By.id("user[password]"));
    //sending password to passwordfield
    invalidPassword.sendKeys("abcdefg");
    //finding login button element
    WebElement loginButton = driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));
   //sending click into loginButton
    loginButton.click();
   //finding actualmessage element
    WebElement actualMessage=driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
    String actualResult=actualMessage.getText();
    //expected message
    String expectedMessage= "Invalid email or password.";
    //validate actual and expected message
    Assert.assertEquals("Unable to log in",actualResult,expectedMessage);
}
}
