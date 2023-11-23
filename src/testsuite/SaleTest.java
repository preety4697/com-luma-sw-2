package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void  verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() throws InterruptedException {

        //Click on Sale menu tab
        WebElement saleTab = driver.findElement(By.xpath("//span[.='Sale']"));
        saleTab.click();
        //Click on ‘Jackets’ link on left side under WOMEN’S DEAL Category
        driver.findElement(By.linkText("Jackets")).click();
        Thread.sleep(3000);

        // Verify the text ‘Jackets’ is displayed
        String expectedText = "Jackets";
        String actualText = driver.findElement(By.xpath("//span[@class='base' or @data-ui-id='page-title-wrapper']")).getText();
        Assert.assertEquals(expectedText, actualText);

        List<WebElement> item = driver.findElements(By.xpath("//a[@class='product-item-link']"));
        System.out.println("Total item : " + item.size());
        System.out.println("-----------------");

        for(WebElement e : item){
            System.out.println(e.getText());
        }
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
