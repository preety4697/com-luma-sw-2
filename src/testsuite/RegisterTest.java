package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSignInPageDisplay() throws InterruptedException {
        //click on create an account link
        driver.findElement(By.linkText("Create an Account")).click();
        Thread.sleep(2000);
        // Verify the text ‘Create New Customer Account’
        String expectedText = "Create New Customer Account";
        //Find the actual text element and get the text from element
        String actualText =  driver.findElement(By.xpath("//span[@class='base']")).getText();

        //Verify the expected and actual text
        Assert.assertEquals(expectedText, actualText);
        Thread.sleep(5000);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException {
        //Click on 'Create an Account link'
        driver.findElement(By.linkText("Create an Account")).click();

        //Find the firstname field
        driver.findElement(By.id("firstname")).sendKeys("Johny");
        //Find the lastname field
        driver.findElement(By.id("lastname")).sendKeys("Bondy");
        //Find email field and enter email field
        driver.findElement(By.id("email_address")).sendKeys("bondyJ123@gmail.com");
        //Find pwd field and enter pwd field
        driver.findElement(By.id("password")).sendKeys("Bondy123@!");
        //confirm pwd field and enter password field
        driver.findElement(By.id("password-confirmation")).sendKeys("Bondy123@!");
        //Click on create an account button
        driver.findElement(By.xpath("//button[.='Create an Account']")).click();
        Thread.sleep(4000);
        //Verify the text 'Thank you for registering with Main Website store.'
        String expectedText ="Thank you for registering with Main Website Store.";
        String actualText = driver.findElement(By.xpath("//div[.='Thank you for registering with Main Website Store.']")).getText();
        Assert.assertEquals(expectedText,actualText);

        //Click on down aero near Welcome
        driver.findElement(By.xpath("(//button[@class='action switch'])[1]")).click();
        Thread.sleep(5000);

         //Click on sign out
         driver.findElement(By.partialLinkText("Sign ")).click();
         Thread.sleep(5000);
         // Verify the text ‘You are signed out’
        String expectedText1 = "You are signed out";
        String actualText1 = driver.findElement(By.xpath("//span[@class='base' and @data-ui-id='page-title-wrapper']")).getText();
        Assert.assertEquals(expectedText1,actualText1);
    }
    @After
    public void teardown(){
        closeBrowser();
    }
}
