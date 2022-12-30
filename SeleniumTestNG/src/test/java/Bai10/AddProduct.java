package Bai10;

import BaseTest.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddProduct extends BaseTest {

    @Parameters("categoryName")
    @Test
    public void AddNewProduct(String categoryName) throws InterruptedException{
        //open add product
        findElement("//li[@class='aiz-side-nav-item']//span[text()='Products']").click();
        findElement("//span[contains(text(),'Add New product')]").click();
        sleep(1000);

        findElement("//input[@placeholder='Product Name']").sendKeys("Lipstick new");
        findElement("//button[@title='Women Clothing & Fashion']").click();
        findElement("//div[@class='dropdown-menu show']//div[@class='bs-searchbox']/input").sendKeys(categoryName, Keys.ENTER);
        sleep(1000);

        findElement("//button[@title='Select Brand']").click();
        findElement("//div[@class='dropdown-menu show']//div[@class='bs-searchbox']/input").sendKeys("Loreal", Keys.ENTER);
        sleep(1000);

        findElement("//input[@placeholder='Unit (e.g. KG, Pc etc)']").sendKeys("pc");
        findElement("//input[@name='min_qty']").clear();
        findElement("//input[@name='min_qty']").sendKeys("2");
        sleep(1000);

        findElement("//tags[@role='tagslist']/span").sendKeys("Cosmetic", Keys.ENTER);
        findElement("(//div[@class='form-control file-amount'])[1]").click();
        findElement("//input[@placeholder='Search your files']").sendKeys("beauty");
        sleep(2000);

        findElement("//div[@title='beauty.png']").click();
        findElement("//button[normalize-space()='Add Files']").click();
        sleep(1000);

        findElement("//div[@class='col-md-1']//span").click();
        sleep(1000);

        findElement("(//button[@title='Nothing selected'])[1]").click();
        findElement("(//input[@aria-label='Search'])[3]").sendKeys("Aqua", Keys.ENTER);
        findElement("(//input[@aria-label='Search'])[3]").clear();
        findElement("(//input[@aria-label='Search'])[3]").sendKeys("Brown", Keys.ENTER);
        sleep(1000);

        Assert.assertTrue(findElement("//button[@title='2 items selected'] ").isDisplayed());
        findElement("//button[@title='2 items selected'] ").click();
        System.out.println(findElement("//button[@title='2 items selected'] //div[@class='filter-option-inner-inner']").getText());
        sleep(1000);

        findElement("//input[@placeholder='Unit price']").clear();
        findElement("//input[@placeholder='Unit price']").sendKeys("10");
        sleep(1000);

        findElement("//input[@placeholder='Discount']").clear();
        findElement("//input[@placeholder='Discount']").sendKeys("10");
        findElement("//div[@class='col-md-3']//button[@title='Flat']").click();
        findElement("//ul[@class='dropdown-menu inner show']//a[@role='option']//span[text()='Percent']").click();
        sleep(1000);

        Actions action = new Actions(driver);
        action.moveToElement(findElement("//button[normalize-space()='Save & Unpublish']")).build().perform();
        findElement("//button[normalize-space()='Save & Unpublish']").click();
        sleep(1000);

    }
}
