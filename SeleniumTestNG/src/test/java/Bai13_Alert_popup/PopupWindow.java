package Bai13_Alert_popup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class PopupWindow {
    WebDriver driver;

    @BeforeClass
    public void createDriver() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @Test
    public void testPopupWindow() throws InterruptedException {
        driver.get("https://demo.guru99.com/popup.php");
        findElement("//a[contains(text(),'Click Here')]").click();

        //Open the first popup window
        String firstwindow = driver.getWindowHandle();
        System.out.println("Parent window: " + firstwindow);

        //Get all new popup windows
        Set <String> windows = driver.getWindowHandles();

        //Duyet vong lap set voi for-each
        for (String window : windows){
            System.out.println("Child window: " + window);
            if (!firstwindow.equals(window)){
                //So sanh tab hien tai voi tab ban dau, neu khac tab ban dau thi chuyen sang
                //Switch to children window
                driver.switchTo().window(window);
                Thread.sleep(2000);

                //1 so ham ho tro kiem tra tab hien tai sau khi da switch
                driver.switchTo().window(window).getCurrentUrl();
                driver.switchTo().window(window).getTitle();

                //Enter email password
                driver.findElement(By.name("emailid")).sendKeys("jennie@gmail.com");
                Thread.sleep(1000);
                driver.findElement(By.name("btnLogin")).click();
                Thread.sleep(1000);
                System.out.println(driver.findElement(By.xpath("//table//td//h2")).getText());
                Thread.sleep(1000);
                //Close child window
                driver.close();
            }
        }
        //Switch to first window
        driver.switchTo().window(firstwindow);
        Thread.sleep(2000);

    }

    @AfterClass
    public void closeBrowser () {
        driver.quit();
    }
    WebElement findElement (String xpath){

        return driver.findElement(By.xpath(xpath));
    }
}


