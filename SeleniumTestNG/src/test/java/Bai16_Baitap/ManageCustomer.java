package Bai16_Baitap;

import Bai10.BaseTest;
import Keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageCustomer extends BaseTest {


    public void loginWithoutAccount(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        findElement("//button[contains(text(),'Login')]").click();
        sleep(1000);
        //verify email + password required
        //verify message displayed
        Assert.assertTrue(WebUI.checkElementExist(driver, "//form/div[1]"), "Message email required does not display");
        Assert.assertTrue(WebUI.checkElementExist(driver, "//form/div[2]"), "Message password required does not display");
        //Check message displayed
        System.out.println("---Password and Email required message---");
        System.out.println(findElement("//form/div[1]").getText());
        System.out.println(findElement("//form/div[2]").getText());
    }

    @Test (priority=0)
    public void loginCRM(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        findElement("//input[@id='email']").sendKeys("admin@example.com");
        findElement("//input[@id='password']").sendKeys("123456");
        findElement("//button[contains(text(),'Login')]").click();
        sleep(1000);
        WebUI.waitForPageLoaded(driver);
    }

    private String COMPANY = "Jennie";
    private String WEBSITE = "https://cmcglobal.com.vn/vi/home-vi/";

    @Test(priority = 1)
    public void addCustomer(){
        //loginCRM();
        sleep(1000);
        WebUI.waitForElementVisible(driver, By.xpath("//span[normalize-space()='Customers']"));
        findElement("//span[normalize-space()='Customers']").click();
        WebUI.waitForPageLoaded(driver);
        findElement("//a[normalize-space()='New Customer']").click();
        WebUI.waitForElementVisible(driver, By.xpath("//a[normalize-space()='Customer Details']"));
        findElement("//input[@id='vat']").sendKeys("123456");
        findElement("//input[@id='phonenumber']").sendKeys("02839474");
        findElement("//input[@id='website']").sendKeys(WEBSITE);
        findElement("//input[@id='company']").sendKeys(COMPANY);
        sleep(1000);
        findElement("//label[@for='groups_in[]']/following-sibling::div").click();
        findElement("//label[@for='groups_in[]']/following-sibling::div//input[@type='search']").sendKeys("Gold", Keys.ENTER);
        sleep(1000);
        findElement("//label[@for='groups_in[]']/following-sibling::div").click();
        sleep(1000);

        findElement("//textarea[@id='address']").sendKeys("Viet Nam");
        findElement("//input[@id='city']").sendKeys("Ha Noi");
        findElement("//input[@id='state']").sendKeys("Ha Noi");
        findElement("//input[@id='zip']").sendKeys("0000");
        sleep(1000);
        findElement("//label[@for='country']/following-sibling::div").click();
        findElement("//label[@for='country']/following-sibling::div//input[@class='form-control']").sendKeys("Vietnam", Keys.ENTER);
        sleep(1000);
        findElement("//button[@class='btn btn-primary only-save customer-form-submiter']").click();
        sleep(1000);
        WebUI.waitForPageLoaded(driver);
        WebUI.waitForElementVisible(driver, By.xpath("//span[@class='alert-title']"));
        //verify message success
        Assert.assertTrue(WebUI.checkElementExist(driver,"//span[@class='alert-title']" ));
        System.out.println(findElement("//span[@class='alert-title']").getAttribute("value"));

        verifyCustomer();
    }

    public void verifyCustomer(){
        findElement("//li[@class='menu-item-customers']").click();
        WebUI.waitForPageLoaded(driver);
        findElement("//input[@class='form-control input-sm']").sendKeys(COMPANY);
        sleep(1000);
        WebUI.waitForPageLoaded(driver);
        WebUI.waitForElementVisible(driver, By.xpath("//tbody/tr[1]/td[3]/a"));
        String getCustomerName = findElement("//tbody/tr[1]/td[3]/a").getText();
        Assert.assertEquals(getCustomerName, COMPANY, "Fail. Customer name not match");

    }

    public void deleteCustomer() {
        WebElement element = findElement("//tbody/tr[1]/td[3]/a");
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
}
