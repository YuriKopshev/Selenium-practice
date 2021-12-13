import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class LiteCartTabTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void start() {
        driver = new FirefoxDriver();
    }

    @Test
    public void checkTemplateTab() {
        driver.get("http://localhost/litecart/admin/");
        wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> elementList = driver.findElements(By.cssSelector("#box-apps-menu a"));
        int numberOfListElements = elementList.size();
        for (int i = 0; i < numberOfListElements; i++) {
            elementList = driver.findElements(By.cssSelector("#box-apps-menu a"));
            elementList.get(i).click();
            driver.findElement(By.cssSelector("h1"));
        }
    }

    @AfterEach
    public void stop() {
        driver.quit();
        driver = null;
    }
}

