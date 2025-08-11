import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class ControllerTest {
    WebDriver driver;
    final String nameUser = "Sarah";
    final String secondName = "Koen";

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String sUrl = "https://atidcollege.co.il/Xamples/ex_controllers.html";
        driver.navigate().to(sUrl);
    }
    @Test
    public void test01() {
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(nameUser);
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(secondName);
        driver.findElement(By.id("sex-1")).click();
        driver.findElement(By.name("tool")).click();
        Select continentSelector = new Select(driver.findElement(By.id("continents")));
        // continentSelector.selectByValue("europe");
        continentSelector.selectByIndex(1);
        driver.findElement(By.id("submit")).submit();
        String titleUrl = driver.getCurrentUrl();
        System.out.println("Title Url: "+titleUrl);
        if(titleUrl.contains(nameUser)&&titleUrl.contains(secondName)) {
            System.out.println("User name - Passed: ");
        } else {
            System.out.println("User name - Failed: ");
        }
    }
    @AfterClass
    public void endSession() {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
            driver.quit();
    }
}
