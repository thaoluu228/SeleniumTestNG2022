package Bai10;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditAndDeleteCategory extends BaseTest{

    @Test(priority = 0)
    public void editCategory () throws InterruptedException{
        findElement("//li[@class='aiz-side-nav-item']//span[text()='Products']").click();
        findElement("//span[contains(text(),'Category')]").click();
        sleep(1000);
        findElement("//input[@id='search']").sendKeys("Beauty and Hair", Keys.ENTER);
        sleep(2000);
        findElement("//a[@title='Edit']").click();
        findElement("//input[@id='order_level']").clear();
        sleep(1000);
        findElement("//input[@id='order_level']").sendKeys("4");
        findElement("//button[@type='submit']").click();
        sleep(1000);
        //Verify message
        Assert.assertTrue(findElement("//span[contains(text(),'Category has been updated successfully')]").isDisplayed());
        sleep(2000);
        findElement("//span[contains(text(),'Category')]").click();
        findElement("//input[@id='search']").sendKeys("Beauty and Hair", Keys.ENTER);
        sleep(2000);
        //Verify level
        Assert.assertEquals(findElement("//tbody//td[4]").getText(),"4");
    }

    @Test(priority = 1)
    public void deleteCategory() throws InterruptedException{
        sleep(1000);
        findElement("//a[@title='Delete']").click();
        findElement("//a[@id='delete-link']").click();
        //Verify message
        Assert.assertTrue(findElement("//span[contains(text(),'Category has been deleted successfully')]").isDisplayed());

    }
}
