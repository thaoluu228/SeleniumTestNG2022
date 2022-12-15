package Bai14_JavaScripExecutor;

import Bai10.BaseTest;
import Keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ScripExecutor extends BaseTest {

    @Test
    public void testScrip01() throws InterruptedException {
        driver.get("https://demo.activeitzone.com/ecommerce/users/login");
        findElement("//i[@class='la la-close fs-20']").click();

        //click object with javascript executor
        JavascriptExecutor js = (JavascriptExecutor) driver;//Khai bao va khoi tao doi tuong
        //sendkey gia tri
        //js.executeScript("arguments[0].setAttribute('value',arguments[1]);", findElement("//input[@id='email']"), "customer@example.com");
        //js.executeScript("arguments[0].setAttribute('value',arguments[1]);", findElement("//input[@id='password']"), "123456");
        js.executeScript("arguments[0].style.border='3px solid red'", findElement("//h1[contains(text(),'Login to your account.')]"));
        js.executeScript("arguments[0].click();", findElement("//button[@onclick='autoFillCustomer()']"));
        js.executeScript("arguments[0].click();", findElement("//button[contains(text(),'Login')]"));
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        WebUI.sleep(2);
    }

    @Test
    public void testScrip02() throws InterruptedException{
        //Khai bao va khoi tao doi tuong
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://anhtester.com/");
        WebUI.sleep(1);

        //click by js
        js.executeScript("arguments[0].click();", findElement("//h3[contains(text(),'Website Testing')]"));
        WebUI.sleep(1);

        //get page title and domain using js
        String title = js.executeScript("return document.title;").toString();
        System.out.println("title: " + title);

        String domain = js.executeScript("return document.domain;").toString();
        System.out.println("domain: " + domain);

        js.executeScript("arguments[0].scrollIntoView(true);", findElement("//img[@alt='Donate for Anh Tester']"));
        WebUI.sleep(2);


    }

    @Test
    public void addBrandCMS() {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();

        //Khai báo WebDriverWait = Explicit Wait
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Chờ đợi menu Brand đến khi sẵn sàng hiển thị để có thể thao tác được
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Brand']")));
        WebUI.waitForElementVisible(driver, By.xpath("//span[normalize-space()='Brand']"));
        driver.findElement(By.xpath("//span[normalize-space()='Brand']")).click();

        String headerAddNewBrand = driver.findElement(By.xpath("//div[@class='card-header']/h5")).getText();
        Assert.assertEquals(headerAddNewBrand, "Add New Brand");

        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Demo brand1", Keys.ENTER);

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td[2]")));

        WebUI.waitForElementVisible(driver, By.xpath("//tbody/tr/td[2]"));

        String brandName = driver.findElement(By.xpath("//tbody/tr/td[2]")).getText();
        System.out.println(brandName);
        Assert.assertEquals(brandName, "Demo brand1");
    }

}
