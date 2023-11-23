package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        //Click on 'Sign In' link
        driver.findElement(By.linkText("Sign In")).click();
        // Find the Email field and enter email address into email field
        driver.findElement(By.id("email")).sendKeys("bondyJ123@gmail.com");
        // Find the Password field and enter password into password field
        driver.findElement(By.id("pass")).sendKeys("Bondy123@!");
        //Click on 'Sign In' button
        driver.findElement(By.id("send2")).click();
        Thread.sleep(4000);
        //Verify the 'Welcome' text is displayed
        String expectedText = "Welcome, account Patel!";
        String actualText = driver.findElement(By.xpath("(//span[@class='logged-in'])[1]")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() throws InterruptedException {

        // click on sign in link
        driver.findElement(By.partialLinkText("Sign ")).click();
        Thread.sleep(3000);

        //Enter valid Email
        driver.findElement(By.id("email")).sendKeys("bondyJ123@gmail.com");
        Thread.sleep(3000);

        // Enter invalid password
        driver.findElement(By.id("pass")).sendKeys("Bondy23@!!");
        Thread.sleep(3000);

        // click on sign in button
        driver.findElement(By.id("send2")).click();
        Thread.sleep(3000);

        //verify the Text
        String expectedText1 = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actualText1 = driver.findElement(By.xpath("//div[.='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']")).getText();
        Assert.assertEquals(expectedText1, actualText1);
    }

    @Test
    public void userShouldLogOutSuccessfully() throws InterruptedException {
        //click on 'Sign In' link
        driver.findElement(By.linkText("Sign In")).click();

        //Enter valid Email
        driver.findElement(By.id("email")).sendKeys("bondyJ123@gmail.com");
        Thread.sleep(3000);

        //Enter the valid password
        driver.findElement(By.id("pass")).sendKeys("Bondy123@!");
        Thread.sleep(3000);

        //Click on 'Sign In' button
        driver.findElement(By.id("send2")).click();
        Thread.sleep(3000);

        //verify the Text
        String expectedText = "Welcome, Johny Bondy!";
        String actualText = driver.findElement(By.xpath("(//span[@class='logged-in'])[1]")).getText();
        Assert.assertEquals(expectedText, actualText);

        //click on down arrow near welcome
        driver.findElement(By.xpath("(//button[@class='action switch'])[1]")).click();
        Thread.sleep(3000);

        //Click on 'Sign Out' link
        driver.findElement(By.partialLinkText("Sign ")).click();

        //Verify the text 'You are Signed out'
        String expectedText1 = "You are signed out";
        String actualText1 = driver.findElement(By.xpath("//span[@class='base' and @data-ui-id='page-title-wrapper']")).getText();
        Assert.assertEquals(expectedText1, actualText1);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}


















