package Bai10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Exercise extends BaseTest {

    @BeforeClass
    public void login(){
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        findElement("//input[@id='email']").sendKeys("admin@example.com");
        findElement("//input[@id='password']").sendKeys("123456");
        findElement("//button[contains(text(),'Login')]").click();
    }
    @Test
    public void AddCategory() throws InterruptedException{
        findElement("//li[@class='aiz-side-nav-item']//span[text()='Products']").click();
        findElement("//span[contains(text(),'Category')]").click();
        findElement("//a[@class='btn btn-primary']").click();
        sleep(1000);
        //category information
        findElement("//input[@id='name']").sendKeys("Beauty & Hair");
        findElement("//div[contains(text(),'No Parent')]").click();
        sleep(2000);
    }

}
