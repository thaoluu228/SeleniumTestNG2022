package Bai10;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddProduct extends BaseTest{

    @BeforeClass
    public void login(){
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        findElement("//input[@id='email']").sendKeys("admin@example.com");
        findElement("//input[@id='password']").sendKeys("123456");
        findElement("//button[contains(text(),'Login')]").click();
    }

    @Test
    public void AddNewProduct() throws InterruptedException{
        //open add product
        findElement("//li[@class='aiz-side-nav-item']//span[text()='Products']").click();
        findElement("//span[contains(text(),'Add New product')]").click();
        sleep(1000);
        findElement("//a[@class='btn btn-primary']").click();
    }
}
