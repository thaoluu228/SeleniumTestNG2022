package Bai13_Alert_popup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertExample {
    WebDriver driver;
    @BeforeClass
    public void createDriver () throws InterruptedException{
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    }

    @Test
    public void TestAlert01() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        findElement("//input[@name='cusid']").sendKeys("12345");
        findElement("//input[@name='submit']").click();

        //Khai bao chuyen huong toi alert
        Alert alert = driver.switchTo().alert();
        // Get message trên alert
        String alertMessage = alert.getText();
        // Displaying alert message
        System.out.println(alertMessage);
        Thread.sleep(2000);
        //Confirm delete
        alert.accept();
        Thread.sleep(2000);
        System.out.println(alert.getText());
        //CLick OK button after delete
        alert.accept();
        Thread.sleep(2000);
    }
    @Test
    public void testAlert02() throws InterruptedException{
        String name = "Jennie";
        driver.get("http://demo.automationtesting.in/Alerts.html");
        findElement("//a[contains(text(),'Alert with Textbox')]").click();
        findElement("//button[@class='btn btn-info']").click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(name);
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
        String message = findElement("//p[@id='demo1']").getText();
        System.out.println(message);
        Assert.assertTrue(message.contains(name));
        Thread.sleep(2000);
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
    WebElement findElement (String xpath){

        return driver.findElement(By.xpath(xpath));
    }
}
