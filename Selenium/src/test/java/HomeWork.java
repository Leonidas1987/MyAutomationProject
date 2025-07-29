import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeWork {
    WebDriver driver;
    @BeforeClass
    public void startSession () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/ex_locators.html");
        driver.manage().window().maximize();
        String url = driver.getCurrentUrl();
        String factualUrl = "Atid College";
        if (url.equals(factualUrl)) {
            System.out.println("Url error: "+factualUrl);
        } else {
            System.out.println("Url check : "+url);
        }
        System.out.println(driver.getTitle());
    }
    @Test
    public void test01() {
        WebElement loc1 = driver.findElement(By.xpath("//div[@id='locator_id']"));
        System.out.println("XPath: "+loc1.getText());
        WebElement loc2 = driver.findElement(By.xpath("//span[@name='locator_name']"));
        System.out.println("XPath: "+loc2.getText());
        WebElement loc3 = driver.findElement(By.xpath("//div[@class='locator_class']"));
        System.out.println("XPath: "+loc3.getText());
        WebElement loc7 = driver.findElement(By.xpath("//input[@class='btn btn-2']"));
        System.out.println("XPath value: "+loc7.getAttribute("value"));
    }
    @AfterClass
    public void endSession() throws InterruptedException {
    Thread.sleep(3000);
    driver.quit();
    }
}
