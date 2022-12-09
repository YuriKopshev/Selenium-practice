import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void checkTabTest() {
        driver.get("http://localhost/litecart/admin/");
        wait = new WebDriverWait(driver, 10);
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> links = driver.findElements(By.cssSelector("#box-apps-menu > li"));
        for (int i = 1; i <= links.size(); i++) {
            driver.findElement(By.cssSelector("#box-apps-menu > li:nth-child(" + i + ")")).click();
            if (driver.findElements(By.cssSelector("#box-apps-menu > li:nth-child(" + i + ") li")).size() != 0) {
                for (int y = 1; y <= driver.findElements(By.cssSelector("#box-apps-menu > li:nth-child(" + i + ") li")).size(); y++) {
                    driver.findElement(By.cssSelector("#box-apps-menu > li:nth-child(" + i + ") > ul > li:nth-child(" + y + ")")).click();
                    driver.findElement(By.cssSelector("h1"));
                }
            }
        }
    }

    @AfterEach
    public void stop() {
        driver.quit();
        driver = null;
    }
}

