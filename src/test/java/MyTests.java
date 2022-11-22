import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyTests {
    private WebDriver driver;

    private WebDriverWait wait;


    @BeforeEach
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void myFirstTest() {
        driver.get(" https://www.google.com");
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys("selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @AfterEach
    public void stop() {
        driver.quit();
        driver = null;
    }
}
