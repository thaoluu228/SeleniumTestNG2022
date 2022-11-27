package Bai10;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddCategory extends BaseTest {

    @Parameters("categoryName")
    @Test(priority = 0)
    public void AddNewCategory(String categoryName) throws InterruptedException {
        //open add category
        findElement("//li[@class='aiz-side-nav-item']//span[text()='Products']").click();
        findElement("//span[contains(text(),'Category')]").click();
        sleep(1000);
        findElement("//a[@class='btn btn-primary']").click();
        //category information
        findElement("//input[@id='name']").sendKeys(categoryName);
        findElement("//div[contains(text(),'No Parent')]").click();
        sleep(1000);
        findElement("//div[@class='dropdown-menu show']//input[@aria-label='Search']").sendKeys("Women", Keys.ENTER);
        findElement("//input[@id='order_level']").sendKeys("1");
        findElement("(//div[@class='form-control file-amount'])[1]").click();
        findElement("//input[@placeholder='Search your files']").sendKeys("banner");
        sleep(3000);
        findElement("//div[@title='Banner-01-01.png']").click();
        findElement("//button[normalize-space()='Add Files']").click();
        sleep(1000);
        findElement("(//div[@class='form-control file-amount'])[2]").click();
        findElement("//input[@placeholder='Search your files']").sendKeys("beauty");
        sleep(2000);
        findElement("//div[@title='beauty.png']").click();
        findElement("//button[normalize-space()='Add Files']").click();
        findElement("//input[@placeholder='Meta Title']").sendKeys("Beauty");
        findElement("//textarea[@name='meta_description']").sendKeys("Lipstick description test");
        findElement("//button[@title='Nothing selected']").click();
        findElement("//div[@class='dropdown-menu show']//input[@aria-label='Search']").sendKeys("Size", Keys.ENTER);
        sleep(1000);
        findElement("//button[normalize-space()='Save']").click();
    }

    @Parameters("categoryName")
    @Test
     public void SearchCategory (String categoryName) throws InterruptedException{
        findElement("//input[@id='search']").sendKeys(categoryName, Keys.ENTER);
        sleep(2000);
        String getCategoryName = findElement("//tbody/tr[1]//td[2]").getText();
       // Assert.assertEquals(getCategoryName,"Beauty and Hair");
        Assert.assertTrue(getCategoryName.equals("Beauty and Hair"));
    }

}
