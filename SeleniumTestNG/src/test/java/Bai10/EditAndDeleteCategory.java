package Bai10;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditAndDeleteCategory extends BaseTest{

    @BeforeClass
    public void login(){
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        findElement("//input[@id='email']").sendKeys("admin@example.com");
        findElement("//input[@id='password']").sendKeys("123456");
        findElement("//button[contains(text(),'Login')]").click();
    }

    @Test
    public void editCategory () throws InterruptedException{
        findElement("//li[@class='aiz-side-nav-item']//span[text()='Products']").click();
        findElement("//span[contains(text(),'Category')]").click();
        sleep(1000);
        findElement("//input[@id='search']").sendKeys("Beauty", Keys.ENTER);
    }
}
